package SCT.Tela;

import SCT.DAO.ChamadosRecentesDAO;
import SCT.DAO.PadraoDAO;
import SCT.Utilidade.ConnectionManager;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ródney
 */
public class TelaCoordenador extends javax.swing.JFrame {

    public TelaCoordenador() {
                initComponents();
                this.setSize(new Dimension(600, 400));
                this.setResizable(false);
                this.setLocationRelativeTo(null);
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBCadasatrarFerramenta = new javax.swing.JButton();
        jBCadastrarMaquina = new javax.swing.JButton();
        jBCadastrarChamado = new javax.swing.JButton();
        jBCadastrarTecnicos = new javax.swing.JButton();
        jBCadastrarFerramentasChamado = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jMBPrincipal = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMIConsultaChamadosRecentesDeCadaTecnico = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de técnicos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N

        jBCadasatrarFerramenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Ferramenta.png"))); // NOI18N
        jBCadasatrarFerramenta.setText(" Ferramentas");
        jBCadasatrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadasatrarFerramentaActionPerformed(evt);
            }
        });

        jBCadastrarMaquina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Maquina.png"))); // NOI18N
        jBCadastrarMaquina.setText("Máquinas");
        jBCadastrarMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarMaquinaActionPerformed(evt);
            }
        });

        jBCadastrarChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Chamado.png"))); // NOI18N
        jBCadastrarChamado.setText("Chamados");
        jBCadastrarChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarChamadoActionPerformed(evt);
            }
        });

        jBCadastrarTecnicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Tecnico.png"))); // NOI18N
        jBCadastrarTecnicos.setText("Técnicos");
        jBCadastrarTecnicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarTecnicosActionPerformed(evt);
            }
        });

        jBCadastrarFerramentasChamado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/FerramentaChamado.png"))); // NOI18N
        jBCadastrarFerramentasChamado.setText("Ferramentas Chamado");
        jBCadastrarFerramentasChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarFerramentasChamadoActionPerformed(evt);
            }
        });

        jBSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Sair.png"))); // NOI18N
        jBSair.setText("Fechar");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCadastrarTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBCadasatrarFerramenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBCadastrarChamado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBCadastrarFerramentasChamado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCadastrarMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadastrarTecnicos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrarFerramentasChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCadasatrarFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrarMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBCadastrarChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jMenu2.setText("Consulta");

        jMIConsultaChamadosRecentesDeCadaTecnico.setText("Chamados recentes de cada técnico");
        jMIConsultaChamadosRecentesDeCadaTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIConsultaChamadosRecentesDeCadaTecnicoActionPerformed(evt);
            }
        });
        jMenu2.add(jMIConsultaChamadosRecentesDeCadaTecnico);

        jMBPrincipal.add(jMenu2);

        jMenu1.setText("Gerar Relatório");
        jMBPrincipal.add(jMenu1);

        jMAjuda.setText("Ajuda");
        jMBPrincipal.add(jMAjuda);

        setJMenuBar(jMBPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        finaliza();
    }//GEN-LAST:event_formWindowClosing

    private void jMIConsultaChamadosRecentesDeCadaTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIConsultaChamadosRecentesDeCadaTecnicoActionPerformed
        try {
            // TODO add your handling code here:
            PadraoDAO dadosDAO = new ChamadosRecentesDAO();
            TelaPesquisaChamadosRecentes listagem = new TelaPesquisaChamadosRecentes(
                this,
                true,
                "Chamados Mais Recentes",
                dadosDAO,
                "chamados_recentes");
        listagem.setLocationRelativeTo(this);
        listagem.setSize(new Dimension(1000,500));
        listagem.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaCoordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMIConsultaChamadosRecentesDeCadaTecnicoActionPerformed

    private void jBCadasatrarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadasatrarFerramentaActionPerformed
        // TODO add your handling code here:
        new TelaGestaoFerramenta(this, true).setVisible(true);
    }//GEN-LAST:event_jBCadasatrarFerramentaActionPerformed

    private void jBCadastrarMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarMaquinaActionPerformed
        // TODO add your handling code here:
        new TelaGestaoMaquina(this, true).setVisible(true);
    }//GEN-LAST:event_jBCadastrarMaquinaActionPerformed

    private void jBCadastrarChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarChamadoActionPerformed
        // TODO add your handling code here:
        new TelaGestaoChamado(this, true).setVisible(true);
    }//GEN-LAST:event_jBCadastrarChamadoActionPerformed

    private void jBCadastrarTecnicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarTecnicosActionPerformed
        // TODO add your handling code here:
        new TelaGestaoTecnico(this, true).setVisible(true);
    }//GEN-LAST:event_jBCadastrarTecnicosActionPerformed

    private void jBCadastrarFerramentasChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarFerramentasChamadoActionPerformed
        // TODO add your handling code here:
        new TelaGestaoFerramentaChamado(this, true).setVisible(true);
    }//GEN-LAST:event_jBCadastrarFerramentasChamadoActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void finaliza() {
        ConnectionManager.desconecta();
        System.exit(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadasatrarFerramenta;
    private javax.swing.JButton jBCadastrarChamado;
    private javax.swing.JButton jBCadastrarFerramentasChamado;
    private javax.swing.JButton jBCadastrarMaquina;
    private javax.swing.JButton jBCadastrarTecnicos;
    private javax.swing.JButton jBSair;
    private javax.swing.JMenu jMAjuda;
    private javax.swing.JMenuBar jMBPrincipal;
    private javax.swing.JMenuItem jMIConsultaChamadosRecentesDeCadaTecnico;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
