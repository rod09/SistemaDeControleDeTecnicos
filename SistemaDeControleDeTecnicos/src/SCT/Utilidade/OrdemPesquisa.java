

package SCT.Utilidade;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author alinda
 */
public class OrdemPesquisa {
    private String nome;//nome da ordenacao
    private ArrayList<String> campos;//lista de campos para ordenacao
    private boolean upperCase;//indica se o indice deve ser pesquisado com upperCase

    public OrdemPesquisa(String nome, ArrayList<String> campos, boolean upper) {
        this.nome=nome;
        this.campos=campos;
        this.upperCase=upper;
    }

    public ArrayList<String> getCampos() {
        return campos;
    }

    public void setCampos(ArrayList<String> campos) {
        this.campos = campos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isUpperCase() {
        return upperCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public String primeiroCampo(){
        if (campos.size() > 0) {
            return campos.get(0);
        }
        return null;

    }

    public String getOrder(boolean ascend){
        String ret = "";
        Iterator iterator = campos.iterator();
        String campo;
        while (iterator.hasNext()) {
            campo = (String) iterator.next();
            if (!ret.trim().isEmpty()) {
                ret += (", ");
            }
            if (isUpperCase()) {
                ret += "UPPER(" + campo + ")";
            } else {
                ret += campo;
            }
            if (!ascend) {
                ret+=" DESC ";
            }

        }
        
        return ret;
    }

   }
