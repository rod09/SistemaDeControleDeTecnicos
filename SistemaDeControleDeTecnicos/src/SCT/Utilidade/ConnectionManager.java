package SCT.Utilidade;

import SCT.Tela.TelaLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionManager {
    private static Connection conexao;

    public static Connection getConexao() {
        return conexao;
    }

    public static void conecta(String username, String password) throws SQLException {
        String serverName   = Configuration.getDataBaseServerIP();
        String dabaBasePort = Configuration.dataBaseServerPort();
        String mydatabase   = Configuration.dataBaseName();
        String myDriver     = Configuration.getDataBaseDriver();
        String url          = "jdbc:" + myDriver
                            + "://" + serverName
                            + ":" + dabaBasePort
                            + "/" + mydatabase;
        try {
            conexao = DriverManager.getConnection(url, username, password);
            System.out.println("Conexao realizada com sucesso!!!!");
        }catch (SQLException e) {
            throw new SQLException("Nao foi possivel conectar ao banco de dados" + e.getMessage());
        }
    }

    public static boolean login() throws SQLException {
        boolean ret = false;
        try {
            if (conexao != null) {
                if (!conexao.isClosed()) {
                    desconecta();
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro no Banco de Dados: " + e.getMessage());
        } catch (Exception e) {
            throw new SQLException("Erro inesperado: " + e.getMessage());
        }
        TelaLogin telaLogin = new TelaLogin(null, true);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setVisible(true);
        try {
            if (conexao != null) {
                ret = !conexao.isClosed();
            }
        } catch (SQLException e) {
            throw new SQLException("Erro no Banco de Dados: " + e.getMessage());
        } catch (Exception e) {
            throw new SQLException("Erro inesperado: " + e.getMessage());
        }
        return ret;
    }

    public static void desconecta() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
                System.out.println("Conexao finalizada com sucesso!!!!");
            } catch (Exception e) {
            }
        }
    }

    public static boolean begin() {
        boolean retorno = false;
        Statement stmt;
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate("begin");
            retorno = true;
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return retorno;
    }

    public static void commit() throws SQLException {
        Statement stmt = conexao.createStatement();
        stmt.executeUpdate("commit");
    }

    public static void rollback() {
        try {
            Statement stmt = conexao.createStatement();
            stmt.executeUpdate("rollback");
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
