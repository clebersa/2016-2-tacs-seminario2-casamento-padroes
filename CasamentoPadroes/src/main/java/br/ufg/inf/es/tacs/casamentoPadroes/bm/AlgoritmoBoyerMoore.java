package br.ufg.inf.es.tacs.casamentoPadroes.bm;

/**
 *
 * @author kaique
 */
public class AlgoritmoBoyerMoore {

    public static void bm(String txt, int n, String padrao, int m) {
        int d[] = new int[maxChar];
        for (int j = 0; j < maxChar; j++) {
            d[j] = m;
        }
        for (int j = 0; j < (m - 1); j++) {
            d[(int) padrao.charAt(j)] = m - j - 1;
        }
        int i = m - 1;

        while (i < n) {
            int k = i;
            int j = m - 1;
            while ((j >= 0) && (txt.charAt(k) == padrao.charAt(j))) {
                j--;
                k--;
            }
            if (j < 0) {
                System.out.println("Casamento na posição: " + (k + 1));
            }
            i = i + d[(int) txt.charAt(i)];
        }

    }
}
