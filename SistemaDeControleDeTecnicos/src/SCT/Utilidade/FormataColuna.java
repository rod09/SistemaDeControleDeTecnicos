package SCT.Utilidade;



import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;



public class FormataColuna  extends DefaultTableColumnModel{
    
    
    public FormataColuna(FontMetrics fm,ArrayList<EstruturaTabela> estruturaTabela) {
               
        int letra  = fm.stringWidth("M");
        int tamanhoColuna=0;

        Iterator iterator = estruturaTabela.iterator();
        int i=0;
        while (iterator.hasNext()) {
            EstruturaTabela estrutura = (EstruturaTabela) iterator.next();
            if (estrutura.getCampo().length()>estrutura.getTamanho()){
                tamanhoColuna=estrutura.getCampo().length();
            }
            else{
                tamanhoColuna=estrutura.getTamanho();
            }
            addColumn (criaColuna(i,tamanhoColuna*letra, fm, true, estrutura.getCampo().toUpperCase()));
            i++;
        }
    }


    
    private TableColumn criaColuna(int indCol, int largura, FontMetrics fm, 
                                    boolean resizeable, String titulo){
        
        int larguraTitulo = fm.stringWidth(titulo+" ");
        if (largura < larguraTitulo){
            largura=larguraTitulo;
        }

        
        TableColumn col = new TableColumn (indCol);
        
        col.setCellRenderer(null); //alinha conteudo a esquerda
        col.setHeaderRenderer(null);
        col.setHeaderValue(titulo);
        col.setPreferredWidth(largura);

        if(!resizeable){
            col.setMaxWidth(largura);
            col.setMinWidth(largura);
        }
        
        col.setResizable(resizeable);
        return col;
     }//fim do metodo criaColuna




}//fim da classe
