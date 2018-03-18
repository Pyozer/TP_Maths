package exo3;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Matrice;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		int taille = 0;

		// Recuperation de la taille de la matrice
		System.out.println("Entrez la taille de la matrice :");
		do {
			if (isNumeric(line = sc.nextLine().trim().toLowerCase()))
				break;
		} while (taille < 10);
		taille = Integer.parseInt(line);

		// Recuperation des nombres
		String[] userInput = new String[taille];
		for (int i = 0; i < userInput.length; i++) {
			System.out.println("Enter " + (char) (97 + i) + " :");
			userInput[i] = sc.nextLine();
		}
		// Creation de la matrice associee
		Element matrice[][] = new Element[taille][taille];
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matrice[i][j] = new Element(userInput[j], i);
			}
		}
		System.out.println("-------------------Matrice Originelle-------------------");
		Matrice.afficherMatrice(matrice);

		// Parcour de la ligne
		ArrayList<Object> result = new ArrayList<>();

		//Calcul de la formule permettant de calculer le determinant
		int indexFin = 0;
		int index = indexFin + 1;
		while (indexFin <= matrice.length - 2) {
			result.add(soustraire(matrice[1][index].numericValue(),matrice[1][indexFin].numericValue()));
			index++;
			if (index > matrice.length - 1) {
				indexFin++;
				index = indexFin + 1;
			}
		}

		// Regarde si l'equation est calculable ou si elle est composé de therme general
		if (isNumeric(result.get(0))) {
			double res = (double)result.get(0);
			for(int x = 1 ; x < result.size() ; x++) {
				res *= (double) result.get(x);
			}
			System.out.print("Determinant : " + res);
		} else {
			System.out.print("Determinant : ");
			for (Object o : result) {
				System.out.print("("+o+")");
			}
			System.out.println();
		}
	}

	public static boolean isNumeric(Object x) {
		if (x instanceof Integer || x instanceof Float || x instanceof Double)
			return true;
		if (!(x instanceof String))
			return false;
		try {
			double i3 = Double.parseDouble((String) x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static Object soustraire(Object x, Object y) {
		if(isNumeric(x) && isNumeric(y)) {
			return (Double)x - (Double)y;
		} else {
			return x + "-" + y;
		}
	}
}
