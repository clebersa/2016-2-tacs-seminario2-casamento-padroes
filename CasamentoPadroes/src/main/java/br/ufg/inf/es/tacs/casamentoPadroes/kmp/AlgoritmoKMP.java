package br.ufg.inf.es.tacs.casamentoPadroes.kmp;

import java.util.Arrays;

/**
 * Implementação do Algoritmo KMP (Knuth-Morris-Pratt) para casamento de padrão.
 *
 * @author cleber
 */
public class AlgoritmoKMP {

    /**
     * Verifica se um padrão ocorre dentro de um texto utilizando o algoritmo
     * KMP (Knuth-Morris-Pratt).
     *
     * @param padrao Padrão a ser procurado.
     * @param texto Texto a se procurar pelo padrão.
     * @return Posição no texto onde o padrão acontece pela primeira vez ou -1
     * caso o padrão não ocorra no texto.
     */
    public static int indiceDe(String padrao, String texto) {
        // Esta verificação condicional não está originalmente no algoritmo, mas 
        // foi inserida aqui para tratar os casos onde o padrão é nulo ou vazio.
        if (padrao != null && padrao.length() > 0) {
            int[] arraySufixo = gerarArraySufixo(padrao);
            int indiceTexto = 0;
            int indicePadrao = 0;
            int contadorComparacoes = 0;
            while (indiceTexto < texto.length()) {
                contadorComparacoes++;
                if (texto.charAt(indiceTexto) == padrao.charAt(indicePadrao)) {
                    if (indicePadrao == padrao.length() - 1) {
                        return indiceTexto - indicePadrao;
                    } else {
                        indiceTexto = indiceTexto + 1;
                        indicePadrao = indicePadrao + 1;
                    }
                } else if (indicePadrao > 0) {
                    indicePadrao = arraySufixo[indicePadrao - 1];
                } else {
                    indiceTexto = indiceTexto + 1;
                }
            }
        }
        return -1;
    }

    private static int[] gerarArraySufixo(String padrao) {
        int[] arraySufixo = new int[padrao.length()];
        arraySufixo[0] = 0;
        int indiceArraySufixo = 1;
        int indicePadrao = 0;
        while (indiceArraySufixo < padrao.length()) {
            if (padrao.charAt(indiceArraySufixo) == padrao.charAt(indicePadrao)) {
                arraySufixo[indiceArraySufixo] = indicePadrao + 1;
                indiceArraySufixo = indiceArraySufixo + 1;
                indicePadrao = indicePadrao + 1;
            } else if (indicePadrao > 0) {
                indicePadrao = arraySufixo[indicePadrao - 1];
            } else {
                arraySufixo[indiceArraySufixo] = 0;
                indiceArraySufixo = indiceArraySufixo + 1;
            }
        }
        System.out.println("Array de sufixo para padrão '" + padrao + "': "
                + Arrays.toString(arraySufixo));
        return arraySufixo;
    }
}
