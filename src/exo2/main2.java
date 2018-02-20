package exo2;

import utils.Affichage;
import utils.Matrice;
import utils.SaisieMatrice;

public class main2 {

	private final static boolean DEBUG = false; // Affiche ou non les messages d'infos
	private final static int TAILLE_MATRICE = 3; // Taille de la matrice (3x3)

	public static void main(String[] args) {
		// Création de la matrice
		double[][] matrice = new double[TAILLE_MATRICE][TAILLE_MATRICE];
		matrice = SaisieMatrice.debutSaisie(TAILLE_MATRICE);

		System.out.println("\nMatrice : ");
		Affichage.afficherMatrice(matrice);

		// Calcule du déterminant avec cofacteurs
		System.out.println("\nDéterminant de la matrice : " + calculDetermMatrice(matrice));
	}

	private static double calculDetermMatrice(double[][] matrice) {

		if(matrice.length == 2) {
			return Matrice.calculDetermMatrice2(matrice);
		}

		// Valeur de base du pivot
		int indexLignePivot = 0;
		int indexColPivot = 0;

		// On vérifie qu'il 'y a pas que des 0 sur la ligne pivot
		while(matrice[indexLignePivot][indexColPivot] == 0 && indexColPivot < matrice.length) {
			if(indexColPivot == matrice.length - 1)
				return 0;
			indexColPivot++;
		}

		double[][] matriceCalc = matrice;

		double[] lignePivot = matriceCalc[indexLignePivot];
		for(int i = 1;i < matriceCalc.length;i++) {
			double coeff = matriceCalc[i][0] / lignePivot[indexColPivot];
			for(int j = 0;j < matriceCalc.length;j++) {
				matriceCalc[i][j] = matriceCalc[i][j] - coeff * lignePivot[j];
			}
		}

		System.out.println("\nMatrice calc:");
		Affichage.afficherMatrice(matriceCalc);

		return matriceCalc[indexLignePivot][indexColPivot] * calculDetermMatrice(Matrice.sousMatriceDouble(matriceCalc, indexLignePivot, indexColPivot));
	}

}