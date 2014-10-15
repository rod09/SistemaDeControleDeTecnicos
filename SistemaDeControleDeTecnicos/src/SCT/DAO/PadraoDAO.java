/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;



import SCT.Classe.IKey;
import SCT.Utilidade.ConnectionManager;
import SCT.Utilidade.EstruturaPesquisa;
import SCT.Utilidade.EstruturaTabela;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alinda
 */
public abstract class PadraoDAO {

    protected Connection connection = null;

    public PadraoDAO() throws SQLException {
        connection = ConnectionManager.getConexao();
        if (connection == null) {
            throw new SQLException("Banco não conectado");
        }
    }

    public ArrayList<EstruturaTabela> getEstrutura(String tabela) 
            throws SQLException{
        ArrayList<EstruturaTabela> estruturaTabela = new ArrayList<>();
        DatabaseMetaData dbmd = connection.getMetaData();
        ResultSet resultSet = dbmd.getColumns(null, null, tabela, "%");
        while (resultSet.next()) {
            String campo = resultSet.getString("COLUMN_NAME");
            String tipo = resultSet.getString("TYPE_NAME");
            int tam = resultSet.getInt("COLUMN_SIZE");

            if (!tipo.equals("bytea")) {
                estruturaTabela.add(new EstruturaTabela(campo, tipo, tam));
            }
        }
        return estruturaTabela;
    }
    
    public String getUsuario()
            throws SQLException{
        String sql = "SELECT USER() AS usuario";
        String usuario = null;
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        //itera no ResultSet
        while (rs.next()) {
            usuario = rs.getString("usuario");
        }
        rs.close();
        pst.close();
        
        return usuario;
    }

    public abstract ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException;

    
    public abstract ArrayList load() throws SQLException;
    
    public abstract ArrayList load(EstruturaPesquisa pesquisa) throws SQLException;
    
    public abstract void add(IKey dado) throws SQLException;

    public abstract void edit(IKey dado) throws SQLException;

    public abstract void remove(IKey dado) throws SQLException;
    
    public abstract IKey consulta(String chave) throws SQLException;
    
    
}
