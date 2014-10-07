
package SCT.Classe;

import java.sql.Date;

/**
 *
 * @author Ródney AGRO
 */
public class Tecnico implements IKey{
    private String codigo;
    private String nome;
    private String email;
    private String telefone;
    private Date data_contratacao;

    public Tecnico() {
    }

    public Tecnico(String codigo, String nome, String email, String telefone, Date data_contratacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.data_contratacao = data_contratacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }
    
    

    /**
     * 
     * @return retorna chave primária
     */
    @Override
    public String getIndex() {
        return codigo;
    }
    
    
}
