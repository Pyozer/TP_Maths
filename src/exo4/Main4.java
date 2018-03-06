package exo4;

import exo2.Main2;
import utils.Matrice;
import utils.SaisieMatrice;

public class Main4 {

	private final static int TAILLE_MATRICE = 3;

	public static void main(String[] args) {
		// Création de la matrice
		Double[][] matrice = new Double[TAILLE_MATRICE][TAILLE_MATRICE];
		matrice = SaisieMatrice.debutSaisie(TAILLE_MATRICE);

		System.out.println("\nMatrice : ");
		Matrice.afficherMatrice(matrice);

		Double[][] matriceInverse = inverserMatrice(matrice);
		System.out.println("\nMatrice inversé: ");
		Matrice.afficherMatrice(matriceInverse);
	}

	public static Double[][] inverserMatrice(Double[][] matrice) {
		double determinant = Main2.calculDetermMatrice(matrice);
		if (determinant == 0) {
			return null;
		}

		double coeff = 1.0 / determinant;

		Double[][] matriceInverse = Matrice.copierMatrice(matrice);

		Double[][] commatriceTransposer = transposerMatrice(calculerCommatrice(matrice));

		// Multiplier chaque nombre de la commatrice transposé par 1 / det(A)
		for (int i = 0; i < commatriceTransposer.length; i++) {
			for (int j = 0; j < commatriceTransposer.length; j++) {
				matriceInverse[i][j] = (double) Math.round(coeff * commatriceTransposer[i][j] * 1000) / 1000;
			}
		}

		return matriceInverse;

	}

	public static Double[][] calculerCommatrice(Double[][] matrice) {
		Double[][] commatrice = Matrice.copierMatrice(matrice);

		for (int i = 0; i < commatrice.length; i++) {
			for (int j = 0; j < commatrice.length; j++) {
				commatrice[i][j] = Math.pow(-1, i + j) * Main2.calculDetermMatrice(Matrice.sousMatriceDouble(matrice, i, j));
			}
		}

		System.out.println("COMMATRICE : ");
		Matrice.afficherMatrice(commatrice);

		return commatrice;
	}

	public static Double[][] transposerMatrice(Double[][] matrice) {
		Double[][] matriceTransposer = Matrice.copierMatrice(matrice);

		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matriceTransposer[i][j] = matrice[j][i];
			}
		}

		System.out.println("MATRICE TRANSPOSER: ");
		Matrice.afficherMatrice(matriceTransposer);

		return matriceTransposer;
	}

}
