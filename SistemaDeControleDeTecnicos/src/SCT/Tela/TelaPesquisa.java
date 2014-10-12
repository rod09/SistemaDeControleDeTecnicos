package SCT.Tela;

import SCT.DAO.PadraoDAO;
import SCT.Utilidade.EstruturaPesquisa;
import SCT.Utilidade.EstruturaTabela;
import SCT.Utilidade.FormataColuna;
import SCT.Utilidade.TabelaPesquisa;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;

/**
 *
 * @author Ródney AGRO
 */
public class TelaPesquisa extends javax.swing.JDialog {

    private TabelaPesquisa tabelaPesquisa;
    private ArrayList<EstruturaTabela> estruturaTabela;
    private int redimensionaColuna;
    private PadraoDAO dao;
    private String tabela;
    private String retornoPesquisa;
    private String campoRetorno;
    private String filtro;

    public TelaPesquisa(
            java.awt.Frame parent,
            boolean modal,
            String titulo,
            PadraoDAO dao,
            String tabela) {
        super(parent, modal);
        this.tabela = tabela;
        this.dao = dao;
        defineEstruturaTabela();
        initComponents();
        setTitle(titulo);
        setLocationRelativeTo(null);
        camposOrdem();
        redimensionaColuna = 0;
        exibePesquisa();
    }

    public TelaPesquisa(java.awt.Frame parent, boolean modal, String titulo, PadraoDAO dao, String tabela, ArrayList<EstruturaTabela> estruturaTabela,
            String camposPesquisa[], String campoRetorno) {

        super(parent, modal);
        initComponents();
        setTitle(titulo);
        this.tabela = tabela;
        this.dao = dao;
        this.estruturaTabela = estruturaTabela;
        this.campoRetorno = campoRetorno;
        jCBOrdemPesq.setModel(new javax.swing.DefaultComboBoxModel(camposPesquisa));
        setLocationRelativeTo(null);
        redimensionaColuna = 0;

        exibePesquisa();
    }

    public TelaPesquisa(java.awt.Frame parent, boolean modal, String titulo, PadraoDAO dao, String tabela,
            String campoRetorno) {
        super(parent, modal);
        initComponents();
        setTitle(titulo);
        this.tabela = tabela;
        this.dao = dao;
        defineEstruturaTabela();
        camposOrdem();
        defineCamposPesquisa();
        this.campoRetorno = campoRetorno;
        setLocationRelativeTo(null);
        redimensionaColuna = 0;
        exibePesquisa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoOrdem = new javax.swing.ButtonGroup();
        jPBarraFeramenta = new javax.swing.JPanel();
        jLPesquisar = new javax.swing.JLabel();
        jTFPesquisaPesq = new javax.swing.JTextField();
        jCBSelecaoAutoPesq = new javax.swing.JCheckBox();
        jPOrdemPesquisa = new javax.swing.JPanel();
        jRBAscendente = new javax.swing.JRadioButton();
        jRBDescendente = new javax.swing.JRadioButton();
        jCBOrdemPesq = new javax.swing.JComboBox();
        jLCarregar = new javax.swing.JLabel();
        qtdeACarregarPesq = new javax.swing.JSpinner();
        btnRecarregaPesq = new javax.swing.JButton();
        btnCancelarPesq = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScroll = new javax.swing.JScrollPane();
        jTResultPesquisa = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPBarraFeramenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLPesquisar.setText("Pesquisar:");

        jTFPesquisaPesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPesquisaPesqKeyReleased(evt);
            }
        });

        jCBSelecaoAutoPesq.setText("Selecao Automatica");

        jPOrdemPesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordem:"));

        grupoOrdem.add(jRBAscendente);
        jRBAscendente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRBAscendente.setSelected(true);
        jRBAscendente.setText("Ascendente");

        grupoOrdem.add(jRBDescendente);
        jRBDescendente.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jRBDescendente.setText("descendente");

        //jCBOrdemPesq.setModel(new javax.swing.DefaultComboBoxModel(camposOrdem()));

        javax.swing.GroupLayout jPOrdemPesquisaLayout = new javax.swing.GroupLayout(jPOrdemPesquisa);
        jPOrdemPesquisa.setLayout(jPOrdemPesquisaLayout);
        jPOrdemPesquisaLayout.setHorizontalGroup(
            jPOrdemPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPOrdemPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPOrdemPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBOrdemPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPOrdemPesquisaLayout.createSequentialGroup()
                        .addComponent(jRBAscendente)
                        .addGap(4, 4, 4)
                        .addComponent(jRBDescendente)))
                .addContainerGap())
        );
        jPOrdemPesquisaLayout.setVerticalGroup(
            jPOrdemPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPOrdemPesquisaLayout.createSequentialGroup()
                .addComponent(jCBOrdemPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPOrdemPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBDescendente)
                    .addComponent(jRBAscendente)))
        );

        jLCarregar.setText("Carregar:");

        btnRecarregaPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/reload.png"))); // NOI18N
        btnRecarregaPesq.setFocusable(false);
        btnRecarregaPesq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRecarregaPesq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRecarregaPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecarregaPesqActionPerformed(evt);
            }
        });

        btnCancelarPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/exit.gif"))); // NOI18N
        btnCancelarPesq.setFocusable(false);
        btnCancelarPesq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarPesq.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPesqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBarraFeramentaLayout = new javax.swing.GroupLayout(jPBarraFeramenta);
        jPBarraFeramenta.setLayout(jPBarraFeramentaLayout);
        jPBarraFeramentaLayout.setHorizontalGroup(
            jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBarraFeramentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBarraFeramentaLayout.createSequentialGroup()
                        .addComponent(jLPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFPesquisaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBarraFeramentaLayout.createSequentialGroup()
                        .addComponent(jPOrdemPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLCarregar)
                        .addGap(26, 26, 26)
                        .addComponent(qtdeACarregarPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBarraFeramentaLayout.createSequentialGroup()
                        .addComponent(jCBSelecaoAutoPesq)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBarraFeramentaLayout.createSequentialGroup()
                        .addComponent(btnRecarregaPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarPesq)
                        .addGap(39, 39, 39))))
        );
        jPBarraFeramentaLayout.setVerticalGroup(
            jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBarraFeramentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisaPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPesquisar)
                    .addComponent(jCBSelecaoAutoPesq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPOrdemPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPBarraFeramentaLayout.createSequentialGroup()
                        .addGroup(jPBarraFeramentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCarregar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPBarraFeramentaLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(qtdeACarregarPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecarregaPesq))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBarraFeramentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarPesq)))
                .addContainerGap())
        );

        jTResultPesquisa.setAutoCreateColumnsFromModel(false);
        jTResultPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Título 3"
            }
        ));
        jTResultPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTResultPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTResultPesquisaMouseClicked(evt);
            }
        });
        jScroll.setViewportView(jTResultPesquisa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Para copiar o conteúdo da célula para a área de trasnsferência, clique duas vezes sobre a mesma");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBarraFeramenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPBarraFeramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPesqActionPerformed
        dispose();
}//GEN-LAST:event_btnCancelarPesqActionPerformed

    private void btnRecarregaPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecarregaPesqActionPerformed
        exibePesquisa();
}//GEN-LAST:event_btnRecarregaPesqActionPerformed

    private void jTFPesquisaPesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPesquisaPesqKeyReleased
        if (jCBSelecaoAutoPesq.isSelected()) {
            exibePesquisa();
        }
    }//GEN-LAST:event_jTFPesquisaPesqKeyReleased

    private EstruturaPesquisa defineCamposPesquisa() {
        EstruturaPesquisa estruturaPesquisa = new EstruturaPesquisa();
        estruturaPesquisa.setCampo(jCBOrdemPesq.getSelectedItem().toString());
        estruturaPesquisa.setAscendente(jRBAscendente.isSelected());

        if (jTFPesquisaPesq.getText().trim().length() > 0) {
            estruturaPesquisa.setCondicao(
                    " WHERE "
                    + jCBOrdemPesq.getSelectedItem().toString()
                    + " LIKE '%"
                    + jTFPesquisaPesq.getText()
                    + "%'");
        }
        int qtdeRegCarregar = ((Integer) qtdeACarregarPesq.getValue()).intValue();
        if (qtdeRegCarregar > 0) {
            estruturaPesquisa.setLimite(qtdeRegCarregar);
        }
        return estruturaPesquisa;
    }

    private void defineEstruturaTabela() {
        try {
            estruturaTabela = dao.getEstrutura(tabela);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Modulo Listagem",
                    JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }

    private void jTResultPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTResultPesquisaMouseClicked
        if (evt.getClickCount() == 2) {
            final JTable tabela = (JTable) evt.getSource();
            final int linha = tabela.getSelectedRow();
            final int coluna = tabela.getSelectedColumn();

            final String conteudoClicado
                    = (String) tabela.getValueAt(linha, coluna);
            StringSelection stringSelection = new StringSelection(conteudoClicado);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        }
    }//GEN-LAST:event_jTResultPesquisaMouseClicked

    public String getRetornoPesquisa() {
        return retornoPesquisa;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        if (filtro.trim().length() > 0) {
            this.filtro = filtro;
            exibePesquisa();
        }
    }

    private void exibePesquisa() {
        try {
            if (redimensionaColuna == 0) {
                jTResultPesquisa.setAutoCreateColumnsFromModel(false);
                FontMetrics fm = jTResultPesquisa.getFontMetrics(jTResultPesquisa.getFont());
                jTResultPesquisa.setColumnModel(new FormataColuna(fm, estruturaTabela));
                redimensionaColuna = 1;
            }

            tabelaPesquisa = new TabelaPesquisa(estruturaTabela, dao.todosToString(defineCamposPesquisa()));
            jTResultPesquisa.setModel(tabelaPesquisa);
            //jTResultPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
            jScroll.setHorizontalScrollBar(new JScrollBar(0));
            jTResultPesquisa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Modulo Listagem",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] camposOrdem() {
        String camposPesquisa[] = new String[estruturaTabela.size()];
        for (int i = 0; i < estruturaTabela.size(); i++) {
            camposPesquisa[i] = estruturaTabela.get(i).getCampo();
        }
        jCBOrdemPesq.setModel(new javax.swing.DefaultComboBoxModel(camposPesquisa));
        return camposPesquisa;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPesq;
    private javax.swing.JButton btnRecarregaPesq;
    private javax.swing.ButtonGroup grupoOrdem;
    private javax.swing.JComboBox jCBOrdemPesq;
    private javax.swing.JCheckBox jCBSelecaoAutoPesq;
    private javax.swing.JLabel jLCarregar;
    private javax.swing.JLabel jLPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBarraFeramenta;
    private javax.swing.JPanel jPOrdemPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBAscendente;
    private javax.swing.JRadioButton jRBDescendente;
    private javax.swing.JScrollPane jScroll;
    private javax.swing.JTextField jTFPesquisaPesq;
    private javax.swing.JTable jTResultPesquisa;
    private javax.swing.JSpinner qtdeACarregarPesq;
    // End of variables declaration//GEN-END:variables
}
