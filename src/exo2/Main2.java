package exo2;

import utils.Matrice;
import utils.Saisie;

public class Main2 {

	private final static boolean DEBUG = false; // Affiche ou non les messages d'infos
	private final static int TAILLE_MATRICE = 3; // Taille de la matrice (3x3)

	public static void main(String[] args) {
		// Création de la matrice
		Double[][] matrice = new Double[TAILLE_MATRICE][TAILLE_MATRICE];
		matrice = Saisie.saisieMatrice(TAILLE_MATRICE);

		System.out.println("\nMatrice : ");
		Matrice.afficherMatrice(matrice);

		// Calcule du déterminant avec cofacteurs
		System.out.println("\nDéterminant de la matrice : " + calculDetermMatrice(matrice));
	}

	public static Double calculDetermMatrice(Double[][] matrice) {

		if (matrice.length == 1) {
			return matrice[0][0];
		}

		if (matrice.length == 2) {
			return Matrice.calculDetermMatrice2(matrice);
		}

		// Valeur de base du pivot
		int indexLignePivot = Matrice.recupererMeilleurLigne(matrice);
		int indexColPivot = 0;

		// On vérifie qu'il y a pas que des 0 sur la ligne pivot
		while (indexColPivot < matrice.length && matrice[indexLignePivot][indexColPivot] == 0) {
			if (indexColPivot == matrice.length - 1)
				return 0.0;
			indexColPivot++;
		}

		Double[][] matriceCalc = Matrice.copierMatrice(matrice);

		Double[] lignePivot = matriceCalc[indexLignePivot];
		for (int i = 0; i < matriceCalc.length; i++) {
			if (i != indexLignePivot) {
				Double coeff = matrice[i][indexColPivot] / lignePivot[indexColPivot];
				for (int j = 0; j < matrice.length; j++) {
					matriceCalc[i][j] = matrice[i][j] - coeff * lignePivot[j];
				}
			}
		}

		System.out.println("\nMatrice calculé:");
		Matrice.afficherMatrice(matriceCalc);

		return Math.pow(-1, indexLignePivot + indexColPivot)
				* matriceCalc[indexLignePivot][indexColPivot]
				* calculDetermMatrice(Matrice.sousMatriceDouble(matriceCalc, indexLignePivot, indexColPivot));
	}

}