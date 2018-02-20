package utils;

import java.util.Scanner;

public class SaisieMatrice {

	public static Double[][] debutSaisie(int tailleMatrice) {
		System.out.println("===== Saisie matrice taille " + tailleMatrice + " =====");

		Scanner sc = new Scanner(System.in);

		Double[][] matrice = new Double[tailleMatrice][tailleMatrice];

		for(int i = 0;i < tailleMatrice;i++) {
			for(int j = 0;j < tailleMatrice;j++) {
				demanderValeurMatrice(i, j);

				while(!sc.hasNextDouble()) {
					System.out.println("Veuillez saisir un chiffre !");
					demanderValeurMatrice(i, j);
					sc.next();
				}
				matrice[i][j] = sc.nextDouble();
			}
		}

		sc.close();

		return matrice;
	}

	private static void demanderValeurMatrice(int i, int j) {
		System.out.print("Ligne " + i + " / Colonne " + j + " = ");
	}
}