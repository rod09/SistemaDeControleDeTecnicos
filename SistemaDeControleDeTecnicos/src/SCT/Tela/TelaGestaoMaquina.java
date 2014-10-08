/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Tela;

import SCT.DAO.MaquinaDAO;
import SCT.Classe.Maquina;
import SCT.Classe.IKey;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alinda
 */
public class TelaGestaoMaquina extends TelaPadrao {

    /**
     * Creates new form TelaGestaoDeContato
     */
    public TelaGestaoMaquina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setComponentes();
        try {
            dadosDAO = new MaquinaDAO();
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Conectando BD", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPDadosContato = new javax.swing.JPanel();
        jLNome = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jTFCodigo = new javax.swing.JTextField();
        jLMaquina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPDadosContato.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Máquina"));

        jLNome.setText("Código");

        jLTelefone.setText("Descricao");

        jTFCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCodigoKeyReleased(evt);
            }
        });

        jLMaquina.setText(" ");

        javax.swing.GroupLayout jPDadosContatoLayout = new javax.swing.GroupLayout(jPDadosContato);
        jPDadosContato.setLayout(jPDadosContatoLayout);
        jPDadosContatoLayout.setHorizontalGroup(
            jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDadosContatoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDadosContatoLayout.createSequentialGroup()
                        .addComponent(jLTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPDadosContatoLayout.createSequentialGroup()
                        .addComponent(jLNome)
                        .addGap(9, 9, 9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPDadosContatoLayout.createSequentialGroup()
                        .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLMaquina))))
        );
        jPDadosContatoLayout.setVerticalGroup(
            jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDadosContatoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNome)
                    .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaquina))
                .addGap(21, 21, 21)
                .addGroup(jPDadosContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefone)
                    .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPDadosContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPDadosContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoKeyReleased
        try {
            // TODO add your handling code here:
            Maquina maquina = (Maquina) dadosDAO.consulta(jTFCodigo.getText().trim());
            jLMaquina.setText(
            maquina != null ? "Código já existe" : "Código não existe"
            );
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoMaquina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFCodigoKeyReleased

    private void setComponentes() {
        setTitle("Gestão de Máquinas");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    protected IKey montaDado() {
        Maquina maquina = 
                new Maquina(jTFCodigo.getText().trim(), jTFDescricao.getText());
        return maquina;
    }

    @Override
    protected boolean validarCampos() {
        if (jTFCodigo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "É obrigatório o preenchimento do campo 'Código'",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (jTFDescricao.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "É obrigatório o preenchimento do campo 'Descricao'",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;

    }

    @Override
    protected void exibirDados() {
        jTFCodigo.setText(((Maquina) dados.get(corrente)).getCodigo());
        jTFDescricao.setText(((Maquina)dados.get(corrente)).getDescricao());
    }

    @Override
    protected void setEstadoVisualizacao() {
        jTFCodigo.setEditable(false);
        jTFDescricao.setEditable(false);
        jLMaquina.setVisible(false);
    }

    @Override
    protected void setEstadoInsercao() {
        jTFCodigo.setEditable(true);
        jTFDescricao.setEditable(true);
        jLMaquina.setVisible(true);
        jLMaquina.setText("");
        jTFCodigo.requestFocusInWindow();
    }

    @Override
    protected void setEstadoEdicao() {
        jTFCodigo.setEditable(false);
        jTFDescricao.setEditable(true);
        jTFDescricao.requestFocusInWindow();
    }

    @Override
    protected void listar() {
        TelaPesquisa listagem = new TelaPesquisa(
                null,
                true,
                "Máquinas Armazenadas",
                dadosDAO,
                "maquina");
        listagem.setLocationRelativeTo(null);
        listagem.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLMaquina;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JPanel jPDadosContato;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFDescricao;
    // End of variables declaration//GEN-END:variables
}
