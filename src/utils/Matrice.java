package utils;

public class Matrice {
	
	/**
	 * Récupère la sous matrice d'une matrice selon la ligne et colonne choisie
	 * @param matrice Matrice
	 * @param iPos Ligne choisie
	 * @param jPos Colonne choisie
	 * @return Sous matrice d'ordre n-1
	 */
	public static double[][] sousMatrice(double[][] matrice, int iPos, int jPos) {
		int tailleSousMatrice = matrice.length - 1;
		double[][] sousMatrice = new double[tailleSousMatrice][tailleSousMatrice];
		
		int iSousMatrice = 0;
		int jSousMatrice = 0;
		
		// On parcours la matrice pour récupérer la sous matrice
		for(int i = 0;i < matrice.length;i++) { // Pour chaque ligne
			if(i != iPos) { // Si on est pas à la ligne à ignorer
				for(int j = 0;j < matrice.length;j++) { // Pour chaque colonne
					if(j != jPos) { // Si on est pas à la colonne à ignorer						
						sousMatrice[iSousMatrice][jSousMatrice] = matrice[i][j]; // On insert dans la sous matrice
						
						jSousMatrice++; // Incrémentation le compteur j de la sous matrice
					}
				}
				jSousMatrice = 0; // Reset la colonne au début
				iSousMatrice++; // Incrémentation du compteur i de la sous matrice
			}
		}
		
		System.out.println("\nSous Matrice : ");
		Affichage.afficherMatrice(sousMatrice);
		
		return sousMatrice;
		
	}
	
	/**
	 * Calcule le déterminant d'une matrice 2x2
	 * @param matrice Matrice 
	 * @return Déterminant de la matrice
	 */
	public static double calculDetermMatrice2(double[][] matrice) {
		if(matrice.length != 2 || (matrice.length == 2 && matrice[0].length != 2)) {
			System.out.println("La matrice n'est pas d'ordre 2 !");
			return 0;
		}
		
		double a = matrice[0][0];
		double b = matrice[0][1];
		double c = matrice[1][0];
		double d = matrice[1][1];
		
		return (a*d) - (c*b);
	}

}
