
package SCT.Classe;

/**
 *
 * @author Ródney AGRO
 */
public class FerramentaChamado implements IKey{
    private String codigo;
    private String chamado;
    private String ferramenta;

    public FerramentaChamado() {
    }

    public FerramentaChamado(String codigo, String chamado, String ferramenta) {
        this.codigo = codigo;
        this.chamado = chamado;
        this.ferramenta = ferramenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getChamado() {
        return chamado;
    }

    public void setChamado(String chamado) {
        this.chamado = chamado;
    }

    public String getFerramenta() {
        return ferramenta;
    }

    public void setFerramenta(String ferramenta) {
        this.ferramenta = ferramenta;
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
