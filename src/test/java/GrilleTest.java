import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GrilleTest {

    @Test
    public void doit_tester() {
        // When
        Grille grille = new Grille();

        // Then
        assertThat(true).isFalse();
    }
}
