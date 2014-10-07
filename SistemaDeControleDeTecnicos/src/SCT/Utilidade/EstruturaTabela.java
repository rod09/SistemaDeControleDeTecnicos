/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SCT.Utilidade;

/**
 *
 * @author alinda
 */
public class EstruturaTabela {
    private String campo;
    private String tipo;
    private int tamanho;

    public EstruturaTabela(String campo, String tipo, int tamanho) {
        this.campo = campo;
        this.tipo = tipo;
        this.tamanho = tamanho;
    }

    public EstruturaTabela() {
    }


    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
