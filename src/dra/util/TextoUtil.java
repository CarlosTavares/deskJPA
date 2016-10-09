/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.util;

import dra.model.Habilidade;
import java.util.List;

/**
 *
 * @author Carlos.Tavares
 */
public class TextoUtil {
    
    public static final String habilidadesToString(List<Habilidade> habilidades) {
        StringBuilder builder = new StringBuilder();
        for (Habilidade habilidade : habilidades) {
            builder.append(habilidade.getDescricao());
            builder.append(", ");
        }
        return builder.toString();
    }    
}
