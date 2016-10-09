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
     * @param texto Texto a se procurar o padrão.
     * @return Posição no texto onde o padrão acontece pela primeira vez ou -1
     * caso o padrão não ocorra no texto.
     */
    public static int indiceDe(String padrao, String texto) {
        // Esta verificação condicional não está originalmente no algoritmo, mas 
        // foi inserida aqui para tratar os casos onde o padrão é nulo ou vazio.
        if (padrao != null && padrao.length() > 0) {
            int[] arrayFalha = gerarArrayDeFalha(padrao);
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
                    indicePadrao = arrayFalha[indicePadrao - 1];
                } else {
                    indiceTexto = indiceTexto + 1;
                }
            }
        }
        return -1;
    }

    private static int[] gerarArrayDeFalha(String padrao) {
        int[] arrayFalha = new int[padrao.length()];
        arrayFalha[0] = 0;
        int indiceArrayFalha = 1;
        int indicePadrao = 0;
        while (indiceArrayFalha < padrao.length()) {
            if (padrao.charAt(indiceArrayFalha) == padrao.charAt(indicePadrao)) {
                arrayFalha[indiceArrayFalha] = indicePadrao + 1;
                indiceArrayFalha = indiceArrayFalha + 1;
                indicePadrao = indicePadrao + 1;
            } else if (indicePadrao > 0) {
                indicePadrao = arrayFalha[indicePadrao - 1];
            } else {
                arrayFalha[indiceArrayFalha] = 0;
                indiceArrayFalha = indiceArrayFalha + 1;
            }
        }
        System.out.println("Array de falha para padrão '" + padrao + "': "
                + Arrays.toString(arrayFalha));
        return arrayFalha;
    }
}
