package br.com.entra21java.util;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lucas Rodrigo
 */
public class Util {
    
    public String getRandomCodigoMatricula() {
        Random r = new Random();
        String listaLetras = "SADBSADBASIDBASOIDBASIOUBDSAIUBDAUSBDOSADUBSAIUDB";
        ArrayList<String> letrasArmazenadas = new ArrayList<>();
        for (int i = 0; i < listaLetras.length(); i++) {
            letrasArmazenadas.add(String.valueOf(listaLetras.charAt(i)));
        }
        int[] numeros = new int[5];
        String[] letras = new String[5];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(10);
        }
        for (int i = 0; i < letras.length; i++) {
            letras[i] = letrasArmazenadas.get(r.nextInt(letrasArmazenadas.size()));
        }
        
        String codigo = "#" + letras[0]
                + numeros[0] + letras[1] + numeros[1]
                + letras[2] + numeros[2] + letras[3]
                + numeros[3] + letras[4] + numeros[4];
        return codigo;
    }
    
}
