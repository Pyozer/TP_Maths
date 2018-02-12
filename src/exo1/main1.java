package exo1;

import utils.Affichage;
import utils.Matrice;
import utils.SaisieMatrice;

public class main1 {

	private final static boolean DEBUG = false; // Affiche ou non les messages d'infos
	private final static int TAILLE_MATRICE = 3; // Taille de la matrice (3x3)

	public static void main(String[] args) {
		// Création de la matrice
		double[][] matrice = new double[TAILLE_MATRICE][TAILLE_MATRICE];
		matrice = SaisieMatrice.debutSaisie(TAILLE_MATRICE);

		System.out.println("\nMatrice : ");
		Affichage.afficherMatrice(matrice);

		// Calcule du déterminant avec cofacteurs
		System.out.println("\nDéterminant de la matrice : " + calculDetermMatrice3(matrice));
	}
	
	

	/**
	 * Calcule le déterminant d'une matrice 3x3
	 * @param matrice Matrice
	 * @return Déterminant de la matrice
	 */
	private static double calculDetermMatrice3(double[][] matrice) {
		if(matrice.length != 3 || (matrice.length == 3 && matrice[0].length != 3)) {
			System.out.println("La matrice n'est pas d'ordre 3 !");
			return 0;
		}

		int i = 0; // On prend la 1ère ligne
		double determinantMatrice = 0;

		for (int j = 0; j < TAILLE_MATRICE; j++) { // Parcours chaques colonnes de la ligne 1
			determinantMatrice += matrice[i][j] * Math.pow(-1, (i + 1) + (j + 1)) * Matrice.calculDetermMatrice2(Matrice.sousMatrice(matrice, i, j));
		}
		return determinantMatrice;
	}

}
