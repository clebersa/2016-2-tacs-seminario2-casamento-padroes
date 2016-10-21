package br.ufg.inf.es.tacs.casamentoPadroes.rk;

/**
 * Implementação do Algoritmo Rabin-Karp para casamento de padrão.
 * @author kaique
 */
public class AlgoritmoRabinKarp {

    private int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i + M), M);
            if (patHash == txtHash) {
                return i;
            }
        }
        //TODO: Kaique deve confirmar que o retorno para a função é -1 nesse caso.
        return -1;
    }
    
    //TODO: Kaique deve especificar como essa função funciona.
    private long hash(String pat, int M){
        return 0;
    }

}
