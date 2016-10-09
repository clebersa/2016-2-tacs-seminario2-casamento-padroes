package br.ufg.inf.es.tacs.casamentoPadroes.kmp;

import java.util.Arrays;

/**
 *
 * @author cleber
 */
public class AlgoritmoKMP {

    /**
     * Verifica se um padrão ocorre dentro de um texto utilizando o algoritmo
     * KMP (Knuth-Morris-Pratt).
     *
     * @param padrao Padrão a ser procurado.
     * @param texto Texto a se procurar o padrão.
     * @return Posição no texto onde o padrão acontece pela primeira vez ou -1
     * caso o padrão não ocorra no texto.
     */
    public static int indiceDe(String padrao, String texto) {
        int[] arrayFalha = gerarArrayDeFalha(padrao);
        int indiceTexto = 0;
        int indicePadrao = 0;
        while (indiceTexto < texto.length()) {
            if (texto.charAt(indiceTexto) == padrao.charAt(indicePadrao)) {
                if (indicePadrao == padrao.length() - 1) {
                    return indiceTexto - indicePadrao;
                } else {
                    indiceTexto = indiceTexto + 1;
                    indicePadrao = indicePadrao + 1;
                }
            } else if (indicePadrao > 0) {
                indicePadrao = arrayFalha[indicePadrao - 1];
            } else {
                indiceTexto = indiceTexto + 1;
            }
        }
        return -1;
    }

    private static int[] gerarArrayDeFalha(String padrao) {
        int[] arrayFalha = new int[padrao.length()];
        if (padrao.length() > 0) {
            arrayFalha[0] = 0;
            int i = 1;
            int j = 0;
            while (i < padrao.length()) {
                if (padrao.charAt(i) == padrao.charAt(j)) {
                    arrayFalha[i] = j + 1;
                    i = i + 1;
                    j = j + 1;
                } else if (j > 0) {
                    j = arrayFalha[j - 1];
                } else {
                    arrayFalha[i] = 0;
                    i = i + 1;
                }
            }
        }
        System.out.println("Array de falha para padrão '" + padrao + "': "
                + Arrays.toString(arrayFalha));
        return arrayFalha;
    }
}
