/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.FerramentaChamado;
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
public class FerramentaChamadoDAO extends PadraoDAO{
    
    public FerramentaChamadoDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<FerramentaChamado> ferramentasChamado = new ArrayList<>();
        String sql = "SELECT * FROM ferramenta_chamado ORDER BY codigo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            FerramentaChamado ferramentaChamado = new FerramentaChamado();
            ferramentaChamado.setCodigo(rs.getString("codigo"));
            ferramentaChamado.setChamado(rs.getString("chamado_codigo"));
            ferramentaChamado.setFerramenta(rs.getString("ferramenta_codigo"));
            //adicionando o objeto a  lista
            ferramentasChamado.add(ferramentaChamado);
        }
        rs.close();
        pst.close();
        return ferramentasChamado;
    }

    @Override
    public void add(IKey dado) throws SQLException {

        String sql = "INSERT INTO ferramenta_chamado(codigo,chamado_codigo,ferramenta_codigo) VALUES (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //SETA OS VALORES
        pst.setString(1, ((FerramentaChamado)dado).getCodigo());
        pst.setString(2, ((FerramentaChamado)dado).getChamado());
        pst.setString(3, ((FerramentaChamado)dado).getFerramenta());

        //EXECUTA
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void edit(IKey dado) throws SQLException {

        String sql = "UPDATE ferramenta_chamado SET chamado_codigo= ?,ferramenta_codigo WHERE codigo=?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, ((FerramentaChamado)dado).getChamado());
        pst.setString(2, ((FerramentaChamado)dado).getFerramenta());
        pst.setString(3, dado.getIndex());

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        String sql = "DELETE FROM ferramenta_chamado WHERE codigo= ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, dado.getIndex());
        pst.execute();
        pst.close();
    }

   
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<FerramentaChamado> ferramentasChamado = new ArrayList<>();
        String sql = 
                "SELECT * FROM ferramenta_chamado ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            FerramentaChamado ferramentaChamado = new FerramentaChamado();
            ferramentaChamado.setCodigo(rs.getString("codigo"));
            ferramentaChamado.setChamado(rs.getString("chamado_codigo"));
            ferramentaChamado.setFerramenta(rs.getString("ferramenta_codigo"));
            //adicionando o objeto a  lista
            ferramentasChamado.add(ferramentaChamado);
        }
        rs.close();
        pst.close();
        return ferramentasChamado;
    }

    
    @Override
    public IKey consulta(String chave) throws SQLException {
         FerramentaChamado ferramentaChamado = null;
        String sql = "SELECT * FROM ferramenta_chamado WHERE codigo = '" + chave + "'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            ferramentaChamado = new FerramentaChamado();
            ferramentaChamado.setCodigo(rs.getString("codigo"));
            ferramentaChamado.setChamado(rs.getString("chamado_codigo"));
            ferramentaChamado.setFerramenta(rs.getString("ferramenta_codigo"));
        }
        return ferramentaChamado;
    }

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
         ArrayList<String[]> ferramentaChamado = new ArrayList<>();
        
        String sql = "SELECT * FROM ferramenta_chamado";
     
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
                { 
                    rs.getString("codigo"),
                    rs.getString("chamado_codigo"),
                    rs.getString("ferramenta_codigo") };

            ferramentaChamado.add(tupla);
        }
        rs.close();
        pst.close();
        return ferramentaChamado;
    }
    
}
