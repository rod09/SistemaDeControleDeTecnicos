/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.Chamado;
import SCT.Classe.IKey;
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
public class ChamadoDAO extends PadraoDAO{
    
    public ChamadoDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<Chamado> chamados = new ArrayList<>();
        String sql = "SELECT * FROM chamado ORDER BY codigo";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Chamado chamado = new Chamado();
            chamado.setCodigo(rs.getString("codigo"));
            chamado.setCodigoTecnico(rs.getString("tecnico_codigo"));
            chamado.setCodigoMaquina(rs.getString("maquina_codigo"));
            chamado.setTitulo(rs.getString("titulo"));
            chamado.setDescricao(rs.getString("descricao"));
            chamado.setData(rs.getTimestamp("data"));
            //adicionando o objeto a  lista
            chamados.add(chamado);
        }
        rs.close();
        pst.close();
        return chamados;
    }

    @Override
    public void add(IKey dado) throws SQLException {

        String sql = 
                "INSERT INTO chamado("
                + "codigo,"
                + "tecnico_codigo,"
                + "maquina_codigo,"
                + "titulo,"
                + "descricao,"
                + "data"
                + ") VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(sql);

        //SETA OS VALORES
        pst.setString(1, dado.getIndex());
        pst.setString(2, ((Chamado)dado).getCodigoTecnico());
        pst.setString(3, ((Chamado)dado).getCodigoMaquina());
        pst.setString(4, ((Chamado)dado).getTitulo());
        pst.setString(5, ((Chamado)dado).getDescricao());
        pst.setTimestamp(6, ((Chamado)dado).getData());
        //EXECUTA
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void edit(IKey dado) throws SQLException {

        String sql = "UPDATE chamado SET "
                + "titulo= ?,"
                + "descricao= ?,"
                + "data= ? "
                + "WHERE codigo= ? AND "
                + "tecnico_codigo= ? AND "
                + "maquina_codigo= ? AND ";

        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, ((Chamado)dado).getTitulo());
        pst.setString(2, ((Chamado)dado).getDescricao());
        pst.setTimestamp(3, ((Chamado)dado).getData());
        pst.setString(4, dado.getIndex());
        pst.setString(5, ((Chamado)dado).getCodigoTecnico());
        pst.setString(6, ((Chamado)dado).getCodigoMaquina());

        pst.executeUpdate();
        pst.close();
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        String sql = "DELETE FROM chamado WHERE codigo= ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, dado.getIndex());
        pst.execute();
        pst.close();
    }

   
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<Chamado> chamados = new ArrayList<>();
        String sql = 
                "SELECT * FROM chamado ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            Chamado chamado = new Chamado();
            chamado.setCodigo(rs.getString("codigo"));
            chamado.setCodigoTecnico(rs.getString("tecnico_codigo"));
            chamado.setCodigoMaquina(rs.getString("maquina_codigo"));
            chamado.setTitulo(rs.getString("titulo"));
            chamado.setDescricao(rs.getString("descricao"));
            chamado.setData(rs.getTimestamp("data"));
            //adicionando o objeto a  lista
            chamados.add(chamado);
        }
        rs.close();
        pst.close();
        return chamados;
    }

    
    @Override
    public IKey consulta(String chave) throws SQLException {
         Chamado chamado = null;
        String sql = "SELECT * FROM chamado WHERE codigo = '" + chave + "'";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            chamado = new Chamado();
            chamado.setCodigo(rs.getString("codigo"));
            chamado.setCodigoTecnico(rs.getString("tecnico_codigo"));
            chamado.setCodigoMaquina(rs.getString("maquina_codigo"));
            chamado.setTitulo(rs.getString("titulo"));
            chamado.setDescricao(rs.getString("descricao"));
            chamado.setData(rs.getTimestamp("data"));
        }
        return chamado;
    }

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<String[]> chamados = new ArrayList<>();
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
        
        String sql = "SELECT * FROM chamado";
     
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
                    rs.getString("tecnico_codigo"),
                    rs.getString("maquina_codigo"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    formataData.format(rs.getTimestamp("data"))
                };

            chamados.add(tupla);
        }
        rs.close();
        pst.close();
        return chamados;
    }
}
