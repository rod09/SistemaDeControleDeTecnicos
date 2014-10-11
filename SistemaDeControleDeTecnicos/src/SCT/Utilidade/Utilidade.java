/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCT.Utilidade;

import java.util.UUID;

/**
 *
 * @author Ródney
 */
public class Utilidade {
    public static String getUUID(String texto){
    String codigoTecnico;
        if(texto.trim().isEmpty()){
        //Gera código aleatório
        UUID codigoTecnicoUUID = UUID.randomUUID();
        //Diminui tamanho do código para 7 caracteres
        codigoTecnico = String.valueOf(codigoTecnicoUUID).substring(0, 7);
        }else{
        codigoTecnico = texto.trim();
        }
        return codigoTecnico;
    }
}
