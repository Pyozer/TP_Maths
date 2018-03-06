package exo1;

import utils.Matrice;
import utils.SaisieMatrice;

public class Main1 {

	private final static boolean DEBUG = false; // Affiche ou non les messages d'infos
	private final static int TAILLE_MATRICE = 3; // Taille de la matrice (3x3)

	public static void main(String[] args) {
		// Création de la matrice
		Double[][] matrice = new Double[TAILLE_MATRICE][TAILLE_MATRICE];
		matrice = SaisieMatrice.debutSaisie(TAILLE_MATRICE);

		System.out.println("\nMatrice : ");
		Matrice.afficherMatrice(matrice);

		// Calcule du déterminant avec cofacteurs
		System.out.println("\nDéterminant de la matrice : " + calculDetermMatrice3(matrice));
	}

	/**
	 * Calcule le déterminant d'une matrice 3x3
	 * 
	 * @param matrice
	 *            Matrice
	 * @return Déterminant de la matrice
	 */
	private static Double calculDetermMatrice3(Double[][] matrice) {
		if (matrice.length != 3 || (matrice.length == 3 && matrice[0].length != 3)) {
			System.out.println("La matrice n'est pas d'ordre 3 !");
			return 0.0;
		}

		if (Matrice.estTriangulaire(matrice)) { // Si matrice triangulaire
			System.out.println("Matrice triangulaire");
			return matrice[0][0] * matrice[1][1] * matrice[2][2];
		}

		int meilleurLigne = Matrice.recupererMeilleurLigne(matrice); // Récupère la meilleur ligne (la où il y a le + de
																		// 0)

		System.out.println("Meilleur ligne: " + meilleurLigne);

		Double determinantMatrice = 0.0;
		for (int j = 0; j < TAILLE_MATRICE; j++) { // Parcours chaques colonnes de la ligne 1
			if (matrice[meilleurLigne][j] != 0) { // Si le nombre est différent de 0 (inutile de calculer si 0)
				determinantMatrice +=
						matrice[meilleurLigne][j]
						* Math.pow(-1, meilleurLigne + j)
						* Matrice.calculDetermMatrice2(Matrice.sousMatriceDouble(matrice, meilleurLigne, j));
			}
		}

		return determinantMatrice;
	}

}
