/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Tela;

import javax.swing.JPanel;

/**
 *
 * @author Ródney
 */
public class TelaTecnico extends javax.swing.JFrame {

    /**
     * Creates new form TelaTecnico
     */
    public TelaTecnico() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMCadastrar = new javax.swing.JMenu();
        jMICadastrarFerramenta = new javax.swing.JMenuItem();
        jMICadastroMaquina = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMILancamentoChamado = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Técnico");

        jMCadastrar.setText("Cadastrar");

        jMICadastrarFerramenta.setText("Ferramenta");
        jMICadastrarFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICadastrarFerramentaActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMICadastrarFerramenta);

        jMICadastroMaquina.setText("Maquina");
        jMICadastroMaquina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICadastroMaquinaActionPerformed(evt);
            }
        });
        jMCadastrar.add(jMICadastroMaquina);

        jMenuBar1.add(jMCadastrar);

        jMenu2.setText("Lançamento");

        jMILancamentoChamado.setText("Chamado");
        jMILancamentoChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMILancamentoChamadoActionPerformed(evt);
            }
        });
        jMenu2.add(jMILancamentoChamado);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Ajuda");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMICadastrarFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICadastrarFerramentaActionPerformed
        // TODO add your handling code here:
        TelaGestaoFerramenta t = new TelaGestaoFerramenta(this,true);
        t.setVisible(true);
    }//GEN-LAST:event_jMICadastrarFerramentaActionPerformed

    private void jMICadastroMaquinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICadastroMaquinaActionPerformed
        // TODO add your handling code here:
        TelaGestaoMaquina t = new TelaGestaoMaquina(this,true);
        t.setVisible(true);
    }//GEN-LAST:event_jMICadastroMaquinaActionPerformed

    private void jMILancamentoChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMILancamentoChamadoActionPerformed
        // TODO add your handling code here:
        TelaGestaoChamado t = new TelaGestaoChamado(this,true);
        t.setVisible(true);
    }//GEN-LAST:event_jMILancamentoChamadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMCadastrar;
    private javax.swing.JMenuItem jMICadastrarFerramenta;
    private javax.swing.JMenuItem jMICadastroMaquina;
    private javax.swing.JMenuItem jMILancamentoChamado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}