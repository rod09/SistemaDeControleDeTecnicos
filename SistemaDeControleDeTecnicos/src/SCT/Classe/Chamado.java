
package SCT.Classe;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author Ródney AGRO
 */
public class Chamado implements IKey{
    private String codigo;
    private String codigoTecnico;
    private String codigoMaquina;
    private String titulo;
    private String descricao;
    private Timestamp data;

    public Chamado() {
    }

    public Chamado(String codigo, String codigoTecnico, String codigoMaquina, String titulo, String descricao, Timestamp data) {
        this.codigo = codigo;
        this.codigoTecnico = codigoTecnico;
        this.codigoMaquina = codigoMaquina;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoTecnico() {
        return codigoTecnico;
    }

    public void setCodigoTecnico(String codigoTecnico) {
        this.codigoTecnico = codigoTecnico;
    }

    public String getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(String codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public String getIndex() {
        return codigo;
    }
    
    
}
