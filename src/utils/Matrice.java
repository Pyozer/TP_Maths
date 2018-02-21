package utils;

public class Matrice {

	/**
	 * Récupère la sous matrice d'une matrice selon la ligne et colonne choisie
	 * 
	 * @param matrice
	 *            Matrice
	 * @param iPos
	 *            Ligne choisie
	 * @param jPos
	 *            Colonne choisie
	 * @return Sous matrice d'ordre n-1
	 */
	public static Double[][] sousMatriceDouble(Double[][] matrice, int iPos, int jPos) {
		System.out.println("METHODE APPELE !");
		int tailleSousMatrice = matrice.length - 1;
		Object[][] sousMatriceStr = new Object[tailleSousMatrice][tailleSousMatrice];
		sousMatriceStr = sousMatriceObject(matrice, iPos, jPos);

		// On converti le tableau de string en Double
		Double[][] sousMatrice = new Double[tailleSousMatrice][tailleSousMatrice];
		// On parcours la matrice pour récupérer la sous matrice
		for (int i = 0; i < tailleSousMatrice; i++) { // Pour chaque ligne
			for (int j = 0; j < tailleSousMatrice; j++) {
				sousMatrice[i][j] = (Double) sousMatriceStr[i][j];
			}
		}

		return sousMatrice;
	}

	/**
	 * Récupère la sous matrice d'une matrice selon la ligne et colonne choisie
	 * 
	 * @param matrice
	 *            Matrice
	 * @param iPos
	 *            Ligne choisie
	 * @param jPos
	 *            Colonne choisie
	 * @return Sous matrice d'ordre n-1
	 */
	public static String[][] sousMatriceString(String[][] matrice, int iPos, int jPos) {
		int tailleSousMatrice = matrice.length - 1;
		Object[][] sousMatriceStr = new Object[tailleSousMatrice][tailleSousMatrice];
		sousMatriceStr = sousMatriceObject(matrice, iPos, jPos);

		// On converti le tableau de string en Double
		String[][] sousMatrice = new String[tailleSousMatrice][tailleSousMatrice];
		// On parcours la matrice pour récupérer la sous matrice
		for (int i = 0; i < tailleSousMatrice; i++) { // Pour chaque ligne
			for (int j = 0; j < tailleSousMatrice; j++) {
				sousMatrice[i][j] = (String) sousMatriceStr[i][j];
			}
		}

		return sousMatrice;
	}

	/**
	 * Récupère la sous matrice d'une matrice selon la ligne et colonne choisie
	 * 
	 * @param matrice
	 *            Matrice
	 * @param iPos
	 *            Ligne choisie
	 * @param jPos
	 *            Colonne choisie
	 * @return Sous matrice d'ordre n-1
	 */
	private static Object[][] sousMatriceObject(Object[][] matrice, int iPos, int jPos) {
		int tailleSousMatrice = matrice.length - 1;
		Object[][] sousMatrice = new Object[tailleSousMatrice][tailleSousMatrice];

		int iSousMatrice = 0;
		int jSousMatrice = 0;

		// On parcours la matrice pour récupérer la sous matrice
		for (int i = 0; i < matrice.length; i++) { // Pour chaque ligne
			if (i != iPos) { // Si on est pas à la ligne à ignorer
				for (int j = 0; j < matrice.length; j++) { // Pour chaque colonne
					if (j != jPos) { // Si on est pas à la colonne à ignorer
						sousMatrice[iSousMatrice][jSousMatrice] = matrice[i][j]; // On insert dans la sous matrice

						jSousMatrice++; // Incrémentation le compteur j de la sous matrice
					}
				}
				jSousMatrice = 0; // Reset la colonne au début
				iSousMatrice++; // Incrémentation du compteur i de la sous matrice
			}
		}

		return sousMatrice;
	}

	/**
	 * Calcule le déterminant d'une matrice 2x2
	 * 
	 * @param matrice
	 *            Matrice
	 * @return Déterminant de la matrice
	 */
	public static Double calculDetermMatrice2(Double[][] matrice) {
		if (matrice.length != 2 || (matrice.length == 2 && matrice[0].length != 2)) {
			System.out.println("La matrice n'est pas d'ordre 2 !");
			return 0.0;
		}

		Double a = matrice[0][0];
		Double b = matrice[0][1];
		Double c = matrice[1][0];
		Double d = matrice[1][1];

		return (a * d) - (c * b);
	}

	public static boolean isTriangular(Object[][] matrice) {

		boolean isTriangularSup = true;
		for (int i = 0; i < matrice.length; i++) {
			for (int j = matrice.length - 1; j > i; j--) {
				if (!matrice[i][j].toString().equals("0.0") && !matrice[i][j].toString().equals("0")) {
					isTriangularSup = false;
				}
			}
		}

		if (!isTriangularSup) {
			for (int i = 0; i < matrice.length; i++) {
				for (int j = 0; j < i; j++) {
					if (!matrice[i][j].toString().equals("0.0") && !matrice[i][j].toString().equals("0")) {
						return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * Affiche une matrice dans la console
	 * 
	 * @param matrice
	 *            Matrice àfficher
	 */
	public static void afficherMatrice(Object[][] matrice) {
		final int NBSPACE = 10;

		for (int i = 0; i < matrice[0].length; i++) {
			for (int j = 0; j < matrice[0].length; j++) {
				String spaces = "";
				for (int nb = 0; nb < NBSPACE - String.valueOf(matrice[i][j]).length(); nb++) {
					spaces += " ";
				}
				System.out.print(matrice[i][j] + spaces);
			}
			System.out.println("");
		}
		System.out.println(""); // Saut de ligne pour faire une séparation
	}
}