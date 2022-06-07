package test.java.it.uniba.app.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ControlloTest {
    /**
     * oggetto controllo.
     */
   private Controllo controllo;
    /**
     * MAX LETTERE
     * numero massimo
     * di lettere.
     */
   private static final int MAXLETTERE = 5;

    /**
     * iniziallizzazione
     * oggetto "controllo".
     */
    @BeforeEach
    final void setUp() {
        controllo = new Controllo(MAXLETTERE);
    }

    /**
     * test
     * metodo
     * controllo parola.
     */
    @Test
    @DisplayName("Test ControlloParola: ")
    public void testControlloParola() {
        assertAll("check dei tentativi inseriti da utente", () -> {
            assertEquals(true, controllo.controlloParola("astuccio"));
            assertEquals(true, controllo.controlloParola("cane"));
            assertEquals(true, controllo.controlloParola(" "));
            assertEquals(false, controllo.controlloParola("fiore"));
        });

    }

    /**
     * test
     * metodo
     * controllo carattere.
     */
    @Test
    @DisplayName("Test ControlloCarattere")
    public void testControllaParola() {
        assertAll("check dei carattere", () -> {
            assertEquals(false, controllo.controlloCaratteri("manurios"));
            assertEquals(true, controllo.controlloCaratteri("c@sa"));
            assertEquals(true, controllo.controlloCaratteri("Raf13fealla"));
        });
    }

    /**
     * test
     * metodo
     * controllo lettere.
     */
    @Test
    @DisplayName("Test ControlloLettere")
    public void testControlloLettere() {

        String parola = "Ciao";
        char[] word = parola.toCharArray();
        assertAll("check delle lettere ", () -> {
            assertEquals(false, controllo.controlloLettere(word, 't'));
            assertEquals(true, controllo.controlloLettere(word, 'a'));
        });
    }

    }
