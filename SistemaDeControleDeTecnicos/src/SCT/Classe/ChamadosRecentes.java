/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Classe;

import java.sql.Timestamp;

/**
 *
 * @author Ródney
 */
public class ChamadosRecentes implements IKey{
    private String chamadoCodigo;
    private String tecnico;
    private String maquina;
    private Timestamp data;

    public ChamadosRecentes() {
    }

    public String getChamadoCodigo() {
        return chamadoCodigo;
    }

    public void setChamadoCodigo(String chamadoCodigo) {
        this.chamadoCodigo = chamadoCodigo;
    }
    
    

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public String getIndex() {
        return chamadoCodigo;
    }
    
    
}
