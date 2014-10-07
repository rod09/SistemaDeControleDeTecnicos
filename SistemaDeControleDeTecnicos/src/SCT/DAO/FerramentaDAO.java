/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.Ferramenta;
import SCT.Classe.IKey;
import SCT.Utilidade.EstruturaPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Alinda
 */
public class FerramentaDAO extends PadraoDAO{
    
    public FerramentaDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();
        String sql = "SELECT * FROM ferramenta ORDER BY codigo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Ferramenta ferramenta = new Ferramenta();
            ferramenta.setCodigo(rs.getString("codigo"));
            ferramenta.setDescricao(rs.getString("descricao"));
            //adicionando o objeto a  lista
            ferramentas.add(ferramenta);
        }
        rs.close();
        pst.close();
        return ferramentas;
    }

    @Override
    public void add(IKey dado) throws SQLException {

        String sql = "INSERT INTO ferramenta(codigo,descricao) VALUES (?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //SETA OS VALORES
        pst.setString(1, ((Ferramenta)dado).getCodigo());
        pst.setString(2, ((Ferramenta)dado).getDescricao());

        //EXECUTA
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void edit(IKey dado) throws SQLException {

        String sql = "UPDATE ferramenta SET descricao= ? WHERE codigo=?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, ((Ferramenta)dado).getDescricao());
        pst.setString(2, ((Ferramenta)dado).getCodigo());

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        String sql = "DELETE FROM ferramenta WHERE codigo = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, dado.getIndex());
        pst.execute();
        pst.close();
    }

   
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<Ferramenta> ferramentas = new ArrayList<>();
        String sql = 
                "SELECT * FROM ferramenta ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Ferramenta ferramenta = new Ferramenta();
            ferramenta.setCodigo(rs.getString("codigo"));
            ferramenta.setDescricao(rs.getString("descricao"));
            //adicionando o objeto a  lista
            ferramentas.add(ferramenta);
        }
        rs.close();
        pst.close();
        return ferramentas;
    }

    
    @Override
    public IKey consulta(String chave) throws SQLException {
         Ferramenta ferramenta = null;
        String sql = "SELECT * FROM ferramenta WHERE codigo = '" + chave + "'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ferramenta = new Ferramenta();
            ferramenta.setCodigo(rs.getString("codigo"));
            ferramenta.setDescricao(rs.getString("descricao"));
        }
        return ferramenta;
    }

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
         ArrayList<String[]> ferramentas = new ArrayList<>();
        
        String sql = "SELECT * FROM ferramenta";
     
         if (pesquisa.getCondicao()!= null && pesquisa.getCondicao().length()>0){
            sql +=pesquisa.getCondicao();
        }
        sql+=" ORDER by " + pesquisa.getCampo() + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }

        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String tupla[] = 
                { rs.getString("codigo"), rs.getString("descricao") };

            ferramentas.add(tupla);
        }
        rs.close();
        pst.close();
        return ferramentas;
    }
}
