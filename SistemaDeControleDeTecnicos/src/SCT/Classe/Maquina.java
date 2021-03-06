
package SCT.Classe;

/**
 *
 * @author Ródney AGRO
 */
public class Maquina implements IKey{
    private String codigo;
    private String descricao;

    public Maquina() {
    }
    
    public Maquina(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * 
     * @return retorna chave primária da função
     */
    @Override
    public String getIndex() {
        return codigo;
    }
    
    
}
