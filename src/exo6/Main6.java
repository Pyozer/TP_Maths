package exo6;

import exo4.Main4;
import utils.Matrice;
import utils.Saisie;

// Calculer A^m pour une matrice diagonalisable
// Paramètre : matrice A , D , P , et la puissance m

public class Main6 {

	private static int taille_matrice = 3;
	private static int puissance_m = 1;

	public static void main(String[] args) {
		// Saisie matrice A
		Double[][] matriceA = Saisie.saisieMatrice("A");
		taille_matrice = matriceA.length;
		
		// Saisie matrice P et D
		Double[][] matriceP = Saisie.saisieMatrice(taille_matrice, "P");
		Double[][] matriceD = Saisie.saisieMatrice(taille_matrice, "D");
		
		// Saisie puissance m
		puissance_m = Saisie.saisieInt("Puissance m = ");

		System.out.println("\nMatrice A : ");
		Matrice.afficherMatrice(matriceA);
		System.out.println("\nMatrice P : ");
		Matrice.afficherMatrice(matriceP);
		System.out.println("\nMatrice D : ");
		Matrice.afficherMatrice(matriceD);

		Double[][] matricePuissance = calculerMatricePuissance(matriceA, matriceP, matriceD);
		System.out.println("\nMatrice A^m: (m = " + puissance_m + ")");
		Matrice.afficherMatrice(matricePuissance);
	}
	
	public static Double[][] calculerMatricePuissance(Double[][] matriceA, Double[][] matriceP, Double[][] matriceD) {
		Double[][] matriceInverseP = Main4.inverserMatrice(matriceP);
		if(matriceInverseP == null)
			return null;
		
		Double[][] matriceDPuissanceM = Matrice.copierMatrice(matriceD);
		for (int i = 0; i < matriceDPuissanceM.length; i++) { // On met à la puissance m la diagonale de D pour avoir D^m
			matriceDPuissanceM[i][i] = Math.pow(matriceDPuissanceM[i][i], puissance_m);
		}
		
		Double[][] matriceAPuissanceM = multiplierMatrice(multiplierMatrice(matriceP, matriceDPuissanceM), matriceInverseP);
		
		return matriceAPuissanceM;
	}
	
	public static Double[][] multiplierMatrice(Double[][] m1, Double[][] m2) {
		if(m1.length > 0 && m2.length > 0 && m1[0].length != m2.length) { // Si nbr de colonne de m1 est différent du nbr de ligne de m2
			return null;
		}
		
		Double[][] matriceResultat = new Double[m1.length][m2[0].length];
		
		for (int i = 0; i < m1.length; ++i)
	        for (int j = 0; j < m2[0].length; ++j) {
	        	matriceResultat[i][j] = 0.0;
	            for (int k = 0; k < m2.length; ++k)
	            	matriceResultat[i][j] += m1[i][k] * m2[k][j];
	        }
		
		return matriceResultat;
	}
}
