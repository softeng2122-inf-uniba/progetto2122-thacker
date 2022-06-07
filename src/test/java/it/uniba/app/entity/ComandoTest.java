package test.java.it.uniba.app.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComandoTest {
    /**
     *
     * oggetto comando.
     */
   private Comando comando;
    /**
     * ESITO
     * esito test.
     */
   private static final int ESITO = 6;

    /**
     * inizializzazione
     * oggetto comando.
     */
    @BeforeEach
   final void setUp() {
        comando = new Comando();
    }

    /**
     * test
     * metodo
     * controllo comando.
     */
    @Test
    @DisplayName("Test Comando : ")
    public void testControlloComando() {
        assertAll("check dei comando ", () -> {
            assertEquals(1, comando.controllaComando("/nuova"));
            assertEquals(-1, comando.controllaComando("/ciao"));
            assertEquals(ESITO, comando.controllaComando("gioca"));

        });

    }
}
