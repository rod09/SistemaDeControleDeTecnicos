/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Tela;


import SCT.Classe.Chamado;
import SCT.Classe.IKey;
import SCT.Classe.Maquina;
import SCT.Classe.Tecnico;
import SCT.DAO.ChamadoDAO;
import SCT.DAO.MaquinaDAO;
import SCT.DAO.TecnicoDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author administrador
 */
public class TelaGestaoChamado extends TelaPadrao {

    /**
     * Creates new form AtividadeView
     */
    public TelaGestaoChamado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        try {
            dadosDAO = new ChamadoDAO();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFTecnicoCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFMaquinaCodigo = new javax.swing.JTextField();
        jLMaquinaDescricao = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLNomeTecnico = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLChamado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestão de Atividade");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Chamado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 10, 255)));

        jLabel1.setText("Código");

        jTFCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCodigoKeyReleased(evt);
            }
        });

        jLabel3.setText("Código do técnico");

        jTFTecnicoCodigo.setToolTipText("");
        jTFTecnicoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFTecnicoCodigoKeyReleased(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFTecnicoCodigoKeyPressed(evt);
            }
        });

        jLabel4.setText("Título");

        jLabel5.setText("Código da maquina");

        jTFMaquinaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFMaquinaCodigoKeyReleased(evt);
            }
        });

        jLMaquinaDescricao.setText("Descrição da máquina");

        try {
            jFTFData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Data");

        jLabel13.setText("Descrição");

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLNomeTecnico.setText("Nome do técnico");

        jLabel2.setText("Data e hora atuais serão inseridas automaticamente");

        jLChamado.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTFTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTFCodigo)
                            .addComponent(jTFMaquinaCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFTecnicoCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLChamado))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLMaquinaDescricao)
                                    .addComponent(jLNomeTecnico))
                                .addGap(14, 14, 14)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLChamado))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFTecnicoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNomeTecnico))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFMaquinaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaquinaDescricao))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFMaquinaCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMaquinaCodigoKeyReleased
        // TODO add your handling code here:
        try {
            MaquinaDAO maquinaDAO = new MaquinaDAO();
            Maquina maquina = (Maquina) maquinaDAO.consulta(jTFMaquinaCodigo.getText());
            String texto =
            (maquina != null)? maquina.getDescricao() : "Máquina não encontrada";
            jLMaquinaDescricao.setText(texto);
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFMaquinaCodigoKeyReleased

    private void jTFTecnicoCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTecnicoCodigoKeyPressed

    }//GEN-LAST:event_jTFTecnicoCodigoKeyPressed

    private void jTFTecnicoCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTecnicoCodigoKeyReleased
        // TODO add your handling code here:
        try {
            TecnicoDAO t = new TecnicoDAO();
            Tecnico tecnico = (Tecnico) t.consulta(jTFTecnicoCodigo.getText());
            String texto =
            (tecnico != null)? tecnico.getNome() : "Técnico não encontrado";
            jLNomeTecnico.setText(texto);
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFTecnicoCodigoKeyReleased

    private void jTFCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigoKeyReleased
        try {
            // TODO add your handling code here:
            Chamado chamado = (Chamado) dadosDAO.consulta(jTFCodigo.getText());
            jLChamado.setText(
                    chamado != null ? "Código já cadastrado" : "Código não cadastrado"
            );
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTFCodigoKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JLabel jLChamado;
    private javax.swing.JLabel jLMaquinaDescricao;
    private javax.swing.JLabel jLNomeTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFMaquinaCodigo;
    private javax.swing.JTextField jTFTecnicoCodigo;
    private javax.swing.JTextField jTFTitulo;
    // End of variables declaration//GEN-END:variables

    @Override
    protected IKey montaDado() {
        //DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        //DateFormat formataHora = new SimpleDateFormat("HH:mm");


        Chamado chamado = new Chamado();
        chamado.setCodigo(jTFCodigo.getText());
        chamado.setCodigoTecnico(jTFTecnicoCodigo.getText());
        chamado.setCodigoMaquina(jTFMaquinaCodigo.getText());
        chamado.setTitulo(jTFTitulo.getText());
        chamado.setDescricao(jTADescricao.getText());
        chamado.setData(new Timestamp(System.currentTimeMillis()));
        
        return chamado;
    }

    @Override
    public void limpaCampos() {
        super.limpaCampos();
        jTADescricao.setText("");
    }
    
    
    @Override
    protected boolean validarCampos() {
        if (jTFTecnicoCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Código do técnico'",
                    "Aviso",
                    0);
            return false;
        }

        if (jFTFData.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Data'",
                    "Aviso",
                    0);
            return false;
        }

        if (jTADescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Descrição'",
                    "Aviso",
                    0);
            return false;
        }

        if (jTFCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Código do chamado'",
                    "Aviso",
                    0);
            return false;
        }


        if (jTFMaquinaCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Código da Máquina'",
                    "Aviso",
                    0);
            return false;
        }

        if (jTFTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "É obrigatório o preenchimento do campo 'Título'",
                    "Aviso",
                    0);
            return false;
        }
        return true;
    }

    @Override
    protected void exibirDados() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = formatador.format(((Chamado) dados.get(corrente)).getData());
        String nomeDoTecnico = "";
        String descricaoMaquina = "";
        
        try {
            TecnicoDAO t = new TecnicoDAO();
            Tecnico tecnico =
                    (Tecnico) t.consulta(((Chamado) dados.get(corrente)).getCodigoTecnico());
            nomeDoTecnico = tecnico.getNome();
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            MaquinaDAO maquinaDAO = new MaquinaDAO();
            Maquina maquina = 
                    (Maquina) maquinaDAO.consulta(((Chamado) dados.get(corrente)).getCodigoMaquina());
            descricaoMaquina = maquina.getDescricao();
        } catch (SQLException ex) {
            Logger.getLogger(TelaGestaoChamado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTFTecnicoCodigo.setText(((Chamado) dados.get(corrente)).getCodigoTecnico());
        jTFCodigo.setText(((Chamado) dados.get(corrente)).getCodigo().trim());
        jTFTitulo.setText(((Chamado) dados.get(corrente)).getTitulo().trim());
        jTFMaquinaCodigo.setText(((Chamado) dados.get(corrente)).getCodigoMaquina().trim());
        jFTFData.setText(dataFormatada);
        jTADescricao.setText(((Chamado) dados.get(corrente)).getDescricao());
        jLNomeTecnico.setText(nomeDoTecnico);
        jLMaquinaDescricao.setText(descricaoMaquina);
    }   

    @Override
    protected void listar() {
        TelaPesquisa listagem = new TelaPesquisa(
                null,
                true,
                "Chamados Armazenados",
                dadosDAO,
                "chamado");
        listagem.setLocationRelativeTo(null);
        listagem.setVisible(true);
    }

    @Override
    protected void setEstadoVisualizacao() {
        jTFTecnicoCodigo.setEditable(false);
        jTFCodigo.setEditable(false);
        jTFTitulo.setEditable(false);
        jTFMaquinaCodigo.setEditable(false);
        jFTFData.setEditable(false);
        jTADescricao.setEditable(false);
        jLChamado.setVisible(false);
    }

    @Override
    protected void setEstadoInsercao() {
        jTFTecnicoCodigo.setEditable(true);
        jTFCodigo.setEditable(true);
        jTFTitulo.setEditable(true);
        jTFMaquinaCodigo.setEditable(true);
        //jFTFData.setEditable(true);
        //jFTFInicio.setEditable(true);
        jTADescricao.setEditable(true);
        jLNomeTecnico.setText("Nome do técnico");
        jLMaquinaDescricao.setText("Descrição da máquina");
        jLChamado.setText("");
        jLChamado.setVisible(true);
    }

    @Override
    protected void setEstadoEdicao() {
        jTFTecnicoCodigo.setEditable(false);
        jTFCodigo.setEditable(false);
        jTFTitulo.setEditable(true);
        jTFMaquinaCodigo.setEditable(false);
        jFTFData.setEditable(true);
        jTADescricao.setEditable(true);
    }
}
