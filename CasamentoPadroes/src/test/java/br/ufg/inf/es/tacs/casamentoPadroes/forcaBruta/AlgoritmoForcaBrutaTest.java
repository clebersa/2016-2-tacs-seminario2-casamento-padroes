package br.ufg.inf.es.tacs.casamentoPadroes.forcaBruta;

import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class AlgoritmoForcaBrutaTest {
    
    public AlgoritmoForcaBrutaTest() {
    }

    @org.junit.Test
    public void testIndexOfPadraoVazio() {
        int result = AlgoritmoForcaBruta.indiceDe("", "abacaabaccabacabaabb");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfTextoVazio() {
        int result = AlgoritmoForcaBruta.indiceDe("abacab", "");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfPadraoMaiorQueTexto() {
        int result = AlgoritmoForcaBruta.indiceDe("abacaabaccabacabaabb", "abacab");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfFalha() {
        int result = AlgoritmoForcaBruta.indiceDe("abc", "abacaabaccabacabaabb");
        assertEquals(-1, result);
    }

    @org.junit.Test
    public void testIndexOfSucesso() {
        int result = AlgoritmoForcaBruta.indiceDe("abacabab", "abacaabaccabacababb");
        assertEquals(10, result);
    }
    
}
