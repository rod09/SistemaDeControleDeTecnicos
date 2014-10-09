package SCT.Utilidade;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/*AbstractTableModel e uma classe abstrata que implementa a interface
 *TableModel. Ela fornece codigo padrao para disparar TableModelEvents
 *com os metodos fireTableRowsDeleted(), fireTableCellUpdated() e
 *fireTableChanged(). Ela tambem gerencia todos os TableModelListeners
 *registrados em um EventListenerList.O metodo findColumn() procura o
 *indice de uma coluna com um dado nome. Esta pesquisa e feita de modo
 *linear e deve ser sobrescrita para modelos de tabelas enormes.Tres metodos
 *devem ser implementados em subclasses concretas: getRowCount(),
 *getColumnCount() e getValueAt(int row, int column).*/
public class TabelaPesquisa extends AbstractTableModel {

    private String colunas[];
    private ArrayList<String[]> dados;

    public TabelaPesquisa(ArrayList<EstruturaTabela> estrutura, ArrayList<String[]> lista) {
        setColunas(estrutura);
        setDados(lista);
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String linhas[] = dados.get(rowIndex);
        return linhas[columnIndex];
    }

    @Override
    public String getColumnName(int pos) {
        return colunas[pos];
    }
    
    
    public int getColumnPos(String name) {
        for (int i = 0; i < colunas.length; i++) {
            if (name.equalsIgnoreCase(colunas[i])) {
                return i;
            }
        }
        return -1;
    }

    public void excluiLinha(int linha) {
        dados.remove(linha);
        fireTableRowsDeleted(linha, linha);
    }

    private void setColunas(ArrayList<EstruturaTabela> estruturaTabela) {
        colunas = new String[estruturaTabela.size()];
        Iterator iterator = estruturaTabela.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            EstruturaTabela est = (EstruturaTabela) iterator.next();
            colunas[i] = est.getCampo();
            i++;
        }
    }

    private void setDados(ArrayList lista) {
        this.dados = lista;
        fireTableStructureChanged();
    }
}//fim da classe

