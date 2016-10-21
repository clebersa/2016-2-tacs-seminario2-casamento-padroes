package br.ufg.inf.es.tacs.casamentoPadroes.kmp;

import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class AlgoritmoKMPTest {

    public AlgoritmoKMPTest() {
    }

    @org.junit.Test
    public void testIndexOfPadraoVazio() {
        int result = AlgoritmoKMP.indiceDe("", "abacaabaccabacabaabb");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfTextoVazio() {
        int result = AlgoritmoKMP.indiceDe("abacab", "");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfPadraoMaiorQueTexto() {
        int result = AlgoritmoKMP.indiceDe("abacaabaccabacabaabb", "abacab");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfFalha() {
        int result = AlgoritmoKMP.indiceDe("abc", "abacaabaccabacabaabb");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfSucesso() {
        int result = AlgoritmoKMP.indiceDe("abacabab", "abacaabaccabacababb");
        assertEquals(10, result);
    }

}
