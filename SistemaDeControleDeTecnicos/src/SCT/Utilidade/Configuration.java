/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Utilidade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Alinda
 */
public class Configuration {
    private static final String ARQUIVO = "configuration.properties";

    public static String lePropriedade(String propriedade) {
        FileInputStream entrada;
        Properties propriedades = new Properties();
        try {
            entrada = new FileInputStream(ARQUIVO);
            propriedades.load(entrada);
        } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro = " + e.getMessage()
                    + "\nAcessando o arquivo " + ARQUIVO,
                    "Classe Configuracao",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        return propriedades.getProperty(propriedade);
    }

    public static String getDataBaseDriverName() {
        return lePropriedade("Database.DriverName");
    }

    public static String getDataBaseDriver() {
        return lePropriedade("Database.Driver");
    }

    public static String getDataBaseServerIP() {
        return lePropriedade("Database.Server.IP");
    }

    public static String dataBaseServerPort() {
        return lePropriedade("Database.Server.Port");
    }

    public static String dataBaseName() {
        return lePropriedade("Database.Name");
    }

    public static String dataBaseUserName() {
        return lePropriedade("Database.Username");
    }

    public static String dataBasePassword() {
        return lePropriedade("Database.Password");
    }

}
