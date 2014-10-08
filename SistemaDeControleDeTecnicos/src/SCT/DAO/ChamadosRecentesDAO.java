/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.DAO;

import SCT.Classe.ChamadosRecentes;
import SCT.Classe.IKey;
import SCT.Utilidade.EstruturaPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Alinda
 */
public class ChamadosRecentesDAO extends PadraoDAO{
    
    public ChamadosRecentesDAO() throws SQLException {
        super();
    }

    @Override
    public ArrayList load() throws SQLException {
        ArrayList<ChamadosRecentes> chamados = new ArrayList<>();
        String sql = "SELECT * FROM chamados_recentes ORDER BY tecnico";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            ChamadosRecentes chamado = new ChamadosRecentes();
            chamado.setTecnico(rs.getString("tecnico"));
            chamado.setMaquina(rs.getString("maquina"));
            chamado.setData(rs.getTimestamp("data"));
            //adicionando o objeto a  lista
            chamados.add(chamado);
        }
        rs.close();
        pst.close();
        return chamados;
    }
 
    @Override
    public ArrayList load(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<ChamadosRecentes> chamados = new ArrayList<>();
        String sql = 
                "SELECT * FROM chamados_recentes ORDER by " 
                + pesquisa.getCampo() 
                + pesquisa.getOrdem();
        
        if (pesquisa.getLimite() > 0) {
            sql += " LIMIT " + pesquisa.getLimite();
        }
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        //itera no ResultSet
        while (rs.next()) {
            ChamadosRecentes chamado = new ChamadosRecentes();
            chamado.setTecnico(rs.getString("tecnico"));
            chamado.setMaquina(rs.getString("maquina"));
            chamado.setData(rs.getTimestamp("data"));
            //adicionando o objeto a  lista
            chamados.add(chamado);
        }
        rs.close();
        pst.close();
        return chamados;
    }

    

    @Override
    public ArrayList todosToString(EstruturaPesquisa pesquisa) throws SQLException {
        ArrayList<String[]> chamados = new ArrayList<>();
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
        
        String sql = "SELECT * FROM chamados_recentes";
     
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
                    rs.getString("tecnico"),
                    rs.getString("maquina"),
                    formataData.format(rs.getTimestamp("data"))
                };

            chamados.add(tupla);
        }
        rs.close();
        pst.close();
        return chamados;
    }

    @Override
    public void edit(IKey dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(IKey dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IKey consulta(String chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(IKey dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
