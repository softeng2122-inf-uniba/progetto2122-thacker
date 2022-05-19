package it.uniba.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class AppTest {
    
    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(
                "app should have a greeting", classUnderTest.getGreeting());
    }
}
