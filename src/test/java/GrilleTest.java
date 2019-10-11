import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class GrilleTest {

    private static final int NOMBRE_LIGNES = 6;
    private static final int NOMBRE_COLONNES = 7;

    @Test
    public void doit_renvoyer_une_grille_vide_à_linitialisation() {
        // When
        Grille grille = new Grille();

        // Then
        String[][] grilleVide = new String[NOMBRE_COLONNES][NOMBRE_LIGNES];
        assertThat(grille.etat()).isEqualTo(grilleVide);
    }

    @Test
    public void ajoutJeton_doit_avoir_un_jeton_en_première_colonne_première_ligne_à_lajout_dun_jeton_en_première_colonne() throws Exception {
        // Given
        Grille grille = new Grille();

        // When
        grille.ajoutJeton(1, "ROUGE");

        // Then
        assertThat(grille.etat()[0][0]).isEqualTo("ROUGE");
    }

    @Test
    public void ajoutJeton_doit_avoir_un_jeton_jaune_en_deuxième_colonne_première_ligne_à_lajout_dun_jeton_jaune_en_deuxième_colonne() throws Exception {
        // Given
        Grille grille = new Grille();

        // When
        grille.ajoutJeton(2, "JAUNE");

        // Then
        assertThat(grille.etat()[1][0]).isEqualTo("JAUNE");
    }

    @Test
    public void ajoutJeton_doit_avoir_un_jeton_jaune_en_deuxième_colonne_deuxième_ligne_à_lajout_dun_jeton_rouge_en_deuxième_colonne_puis_dun_jeton_jaune() throws Exception {
        // Given
        Grille grille = new Grille();
        grille.ajoutJeton(2, "ROUGE");

        // When
        grille.ajoutJeton(2, "JAUNE");

        // Then
        assertThat(grille.etat()[1][1]).isEqualTo("JAUNE");
    }

    @Test
    public void ajoutJeton_ne_doit_pas_permettre_dajouter_plus_de_6_jetons() throws Exception {
        // Given
        Grille grille = new Grille();
        grille.ajoutJeton(3, "ROUGE");
        grille.ajoutJeton(3, "ROUGE");
        grille.ajoutJeton(3, "ROUGE");
        grille.ajoutJeton(3, "ROUGE");
        grille.ajoutJeton(3, "ROUGE");
        grille.ajoutJeton(3, "ROUGE");

        // When
        Throwable exception = catchThrowable(() -> grille.ajoutJeton(3, "JAUNE"));

        // Then
        assertThat(exception).isInstanceOf(ColonnePleineException.class);
        assertThat(grille.etat()[2]).hasSize(6);
        assertThat(grille.etat()[2][0]).isEqualTo("ROUGE");
        assertThat(grille.etat()[2][1]).isEqualTo("ROUGE");
        assertThat(grille.etat()[2][2]).isEqualTo("ROUGE");
        assertThat(grille.etat()[2][3]).isEqualTo("ROUGE");
        assertThat(grille.etat()[2][4]).isEqualTo("ROUGE");
        assertThat(grille.etat()[2][5]).isEqualTo("ROUGE");
    }

    @Test
    public void ajoutJeton_doit_avoir_maximum_7_colonnes() throws Exception {
        // Given
        Grille grille = new Grille();

        // When
        Throwable exception = catchThrowable(() -> grille.ajoutJeton(NOMBRE_COLONNES + 1, "JAUNE"));

        // Then
        assertThat(exception).isInstanceOf(ColonneInexistante.class);
        assertThat(grille.etat()[0]).containsOnlyNulls();
        assertThat(grille.etat()[1]).containsOnlyNulls();
        assertThat(grille.etat()[2]).containsOnlyNulls();
        assertThat(grille.etat()[3]).containsOnlyNulls();
        assertThat(grille.etat()[4]).containsOnlyNulls();
        assertThat(grille.etat()[5]).containsOnlyNulls();
        assertThat(grille.etat()[6]).containsOnlyNulls();
    }

    @Test
    public void ajoutJeton_ne_doit_pas_avoir_une_colonne_négative_ou_égale_à_0() throws Exception {
        // Given
        Grille grille = new Grille();

        // When
        Throwable exception = catchThrowable(() -> grille.ajoutJeton(0, "JAUNE"));

        // Then
        assertThat(exception).isInstanceOf(ColonneInexistante.class);
        assertThat(grille.etat()[0]).containsOnlyNulls();
        assertThat(grille.etat()[1]).containsOnlyNulls();
        assertThat(grille.etat()[2]).containsOnlyNulls();
        assertThat(grille.etat()[3]).containsOnlyNulls();
        assertThat(grille.etat()[4]).containsOnlyNulls();
        assertThat(grille.etat()[5]).containsOnlyNulls();
        assertThat(grille.etat()[6]).containsOnlyNulls();
    }

    @Test
    public void vider_doit_vider_la_grille() throws Exception {
        // Given
        Grille grille = new Grille();
        grille.ajoutJeton(3, "ROUGE");

        // When
        grille.vider();

        // Then
        assertThat(grille.etat()[0]).containsOnlyNulls();
        assertThat(grille.etat()[1]).containsOnlyNulls();
        assertThat(grille.etat()[2]).containsOnlyNulls();
        assertThat(grille.etat()[3]).containsOnlyNulls();
        assertThat(grille.etat()[4]).containsOnlyNulls();
        assertThat(grille.etat()[5]).containsOnlyNulls();
        assertThat(grille.etat()[6]).containsOnlyNulls();
    }
}
