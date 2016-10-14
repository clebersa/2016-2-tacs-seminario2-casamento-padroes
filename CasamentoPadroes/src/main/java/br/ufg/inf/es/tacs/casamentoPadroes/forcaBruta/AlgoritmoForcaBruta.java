package br.ufg.inf.es.tacs.casamentoPadroes.forcaBruta;

/**
 * Implementação do Algoritmo de Força Bruta para casamento de padrão.
 *
 * @author cleber
 */
public class AlgoritmoForcaBruta {

    /**
     * Verifica se um padrão ocorre dentro de um texto utilizando o algoritmo de
     * Força Bruta.
     *
     * @param padrao Padrão a ser procurado.
     * @param texto Texto a se procurar pelo padrão.
     * @return Posição no texto onde o padrão acontece pela primeira vez ou -1
     * caso o padrão não ocorra no texto.
     */
    public static int indiceDe(String padrao, String texto) {
        int tamanhoPadrao = padrao.length();
        int tamanhoTexto = texto.length();
        for (int indiceBusca = 0; indiceBusca < tamanhoTexto - tamanhoPadrao; indiceBusca++) {
            int indicePadrao;
            for (indicePadrao = 0; indicePadrao < tamanhoPadrao; indicePadrao++) {
                if (texto.charAt(indiceBusca + indicePadrao) != padrao.charAt(indicePadrao)) {
                    break;
                }
            }
            if (indicePadrao == tamanhoPadrao) {
                return indiceBusca;
            }
        }
        return -1;
    }
}
