/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.Maquina;
import SCT.Classe.IKey;
import SCT.Utilidade.EstruturaPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ródney
 */
public class MaquinaDAO extends PadraoDAO{
    
    public MaquinaDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<Maquina> maquinas = new ArrayList<>();
        String sql = "SELECT * FROM maquina ORDER BY codigo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Maquina maquina = new Maquina();
            maquina.setCodigo(rs.getString("codigo"));
            maquina.setDescricao(rs.getString("descricao"));
            //adicionando o objeto a  lista
            maquinas.add(maquina);
        }
        rs.close();
        pst.close();
        return maquinas;
    }

    @Override
    public void add(IKey dado) throws SQLException {

        String sql = "INSERT INTO maquina(codigo,descricao) VALUES (?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //SETA OS VALORES
        pst.setString(1, ((Maquina)dado).getCodigo());
        pst.setString(2, ((Maquina)dado).getDescricao());

        //EXECUTA
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void edit(IKey dado) throws SQLException {

        String sql = "UPDATE maquina SET descricao= ? WHERE codigo=?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, ((Maquina)dado).getDescricao());
        pst.setString(2, ((Maquina)dado).getCodigo());

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        String sql = "DELETE FROM maquina WHERE codigo = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, dado.getIndex());
        pst.execute();
        pst.close();
    }

   
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<Maquina> maquinas = new ArrayList<>();
        String sql = 
                "SELECT * FROM maquina ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Maquina funcao = new Maquina();
            funcao.setCodigo(rs.getString("codigo"));
            funcao.setDescricao(rs.getString("descricao"));
            //adicionando o objeto a  lista
            maquinas.add(funcao);
        }
        rs.close();
        pst.close();
        return maquinas;
    }

    
    @Override
    public IKey consulta(String chave) throws SQLException {
        Maquina maquina = null;
        String sql = "SELECT * FROM maquina WHERE codigo = '" + chave + "'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            maquina = new Maquina();
            maquina.setCodigo(rs.getString("codigo"));
            maquina.setDescricao(rs.getString("descricao"));
        }
        return maquina;
    }

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
         ArrayList<String[]> maquinas = new ArrayList<>();
        
        String sql = "SELECT * FROM maquina";
     
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

            maquinas.add(tupla);
        }
        rs.close();
        pst.close();
        return maquinas;
    }
}
