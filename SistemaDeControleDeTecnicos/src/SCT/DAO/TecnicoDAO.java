/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.Maquina;
import SCT.Classe.IKey;
import SCT.Classe.Tecnico;
import SCT.Utilidade.EstruturaPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Alinda
 */
public class TecnicoDAO extends PadraoDAO{
    
    public TecnicoDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM tecnico ORDER BY codigo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Tecnico tecnico = new Tecnico();
            tecnico.setCodigo(rs.getString("codigo"));
            tecnico.setNome(rs.getString("nome"));
            tecnico.setEmail(rs.getString("email"));
            tecnico.setTelefone(rs.getString("telefone"));
            tecnico.setData_contratacao(rs.getDate("data_contratacao"));
            //adicionando o objeto a  lista
            tecnicos.add(tecnico);
        }
        rs.close();
        pst.close();
        return tecnicos;
    }

    @Override
    public void add(IKey dado) throws SQLException {

        String sql = 
                "INSERT INTO tecnico(codigo,nome,email,telefone,data_contratacao) VALUES (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //SETA OS VALORES
        pst.setString(1, ((Tecnico)dado).getCodigo());
        pst.setString(2, ((Tecnico)dado).getNome());
        pst.setString(3, ((Tecnico)dado).getEmail());
        pst.setString(4, ((Tecnico)dado).getTelefone());
        pst.setDate(5, ((Tecnico)dado).getData_contratacao());
        //EXECUTA
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void edit(IKey dado) throws SQLException {

        String sql = "UPDATE tecnico SET nome= ?,email= ?, telefone= ?, data_contratacao= ? WHERE codigo= ?";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, ((Tecnico)dado).getNome());
        pst.setString(2, ((Tecnico)dado).getEmail());
        pst.setString(3, ((Tecnico)dado).getTelefone());
        pst.setDate(4, ((Tecnico)dado).getData_contratacao());
        pst.setString(5, ((Tecnico)dado).getCodigo());

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        String sql = "DELETE FROM tecnico WHERE codigo= ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, dado.getIndex());
        pst.execute();
        pst.close();
    }

   
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = 
                "SELECT * FROM tecnico ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Tecnico tecnico = new Tecnico();
            tecnico.setCodigo(rs.getString("codigo"));
            tecnico.setNome(rs.getString("nome"));
            tecnico.setEmail(rs.getString("email"));
            tecnico.setTelefone(rs.getString("telefone"));
            tecnico.setData_contratacao(rs.getDate("data_contratacao"));
            //adicionando o objeto a  lista
            tecnicos.add(tecnico);
        }
        rs.close();
        pst.close();
        return tecnicos;
    }

    
    @Override
    public IKey consulta(String chave) throws SQLException {
         Tecnico tecnico = null;
        String sql = "SELECT * FROM tecnico WHERE codigo = '" + chave + "'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            tecnico = new Tecnico();
            tecnico.setCodigo(rs.getString("codigo"));
            tecnico.setNome(rs.getString("nome"));
            tecnico.setEmail(rs.getString("email"));
            tecnico.setTelefone(rs.getString("telefone"));
            tecnico.setData_contratacao(rs.getDate("data_contratacao"));
        }
        return tecnico;
    }

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
         ArrayList<String[]> funcoes = new ArrayList<>();
        
        String sql = "SELECT * FROM tecnico";
     
         if (pesquisa.getCondicao()!= null && pesquisa.getCondicao().length()>0){
            sql +=pesquisa.getCondicao();
        }
        sql+=" ORDER by " + pesquisa.getCampo() + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String tupla[] = 
                { 
                    rs.getString("codigo"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString(("telefone")),
                    formatador.format(rs.getDate("data_contratacao"))
                };

            funcoes.add(tupla);
        }
        rs.close();
        pst.close();
        return funcoes;
    }
}
