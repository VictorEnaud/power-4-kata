import java.util.Arrays;
import java.util.List;

public class Grille {

    private static final int NOMBRE_LIGNES = 6;
    private static final int NOMBRE_COLONNES = 7;
    private static final Object CELLULE_VIDE = null;
    private final String[][] etat;

    public Grille() {
        etat = new String[NOMBRE_COLONNES][NOMBRE_LIGNES];
    }

    public String[][] etat() {
        return etat;
    }

    public void ajoutJeton(int numéroColonne, String jeton) throws ColonnePleineException, ColonneInexistante {
        if (numéroColonne > NOMBRE_COLONNES || numéroColonne <= 0) {
            throw new ColonneInexistante();
        }

        int indexColonne = numéroColonne - 1;
        List colonne = Arrays.asList(etat[indexColonne]);

        int premièreCelluleVide = colonne.indexOf(CELLULE_VIDE);

        if (premièreCelluleVide == -1) {
            throw new ColonnePleineException();
        }

        etat[indexColonne][premièreCelluleVide] = jeton;
    }

    public void vider() {
        for (int colonneIndex = 0; colonneIndex < NOMBRE_COLONNES; colonneIndex++) {
            for (int ligneIndex = 0; ligneIndex < NOMBRE_LIGNES; ligneIndex++) {
                etat[colonneIndex][ligneIndex] = null;
            }
        }
    }
}
