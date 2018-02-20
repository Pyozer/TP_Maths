package utils;

public class Affichage {
	
	/**
	 * Affiche une matrice dans la console
	 * @param matrice Matrice àfficher
	 */
	public static void afficherMatrice(Object[][] matrice) {				
		// On parcours la matrice
		for(int i = 0;i < matrice.length;i++) { // Pour chaque ligne
			System.out.print("[");
			for(int j = 0;j < matrice[i].length;j++) { // Pour chaque colonne
				System.out.print(" " + String.valueOf(matrice[i][j]) + " ");
			}
			System.out.println("]");
		}
	}

}
