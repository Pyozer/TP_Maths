package utils;

import java.util.Scanner;

public class Saisie {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static Double[][] saisieMatrice() {
		return saisieMatrice("");
	}

	public static Double[][] saisieMatrice(String nom_matrice) {
		System.out.println("===== Quelle est la taille de la matrice " + nom_matrice + " carrée ? =====");

		demanderTailleMatrice();

		while (!sc.hasNextInt()) {
			System.out.println("Veuillez saisir un chiffre !");
			demanderTailleMatrice();
			sc.next();
		}

		int taille = sc.nextInt();

		return saisieMatrice(taille);
	}
	
	public static Double[][] saisieMatrice(int tailleMatrice) {
		return saisieMatrice(tailleMatrice, "");
	}

	public static Double[][] saisieMatrice(int tailleMatrice, String nom_matrice) {
		System.out.println("===== Saisie matrice " + nom_matrice + " taille " + tailleMatrice + " =====");

		Double[][] matrice = new Double[tailleMatrice][tailleMatrice];

		for (int i = 0; i < tailleMatrice; i++) {
			for (int j = 0; j < tailleMatrice; j++) {
				demanderValeurMatrice(i, j);

				while (!sc.hasNextDouble()) {
					System.out.println("Veuillez saisir un chiffre !");
					demanderValeurMatrice(i, j);
					sc.next();
				}
				matrice[i][j] = sc.nextDouble();
			}
		}

		return matrice;
	}

	public static int saisieInt(String msg) {
		System.out.print(msg);

		while (!sc.hasNextInt()) {
			System.out.println("Veuillez saisir un chiffre !");
			System.out.print(msg);
			sc.next();
		}

		int value = sc.nextInt();

		return value;
	}

	private static void demanderTailleMatrice() {
		System.out.print("Taille = ");
	}

	private static void demanderValeurMatrice(int i, int j) {
		System.out.print("Ligne " + i + " / Colonne " + j + " = ");
	}
}