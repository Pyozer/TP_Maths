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
		Object matrice[][] = new Object[taille][taille];
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matrice[i][j] = new Element(userInput[j], i);
			}
		}
		System.out.println("-------------------Matrice Originelle-------------------");
		Matrice.afficherMatrice(matrice);

		// Parcour de la ligne
		ArrayList<Object> result = new ArrayList<>();

		int indexFin = 0;
		int index = indexFin + 1;
		while (indexFin <= matrice.length - 2) {
			result.add(soustraire(matrice[1][index],matrice[1][indexFin]));
			index++;
			if (index > matrice.length - 1) {
				indexFin++;
				index = indexFin + 1;
			}
		}

		// Regarde si l'equation est faisable ou non
		if (isNumeric(result.get(0))) {
			int res = 0;
			for (Object o : result) {
				res = (int) o;
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
		if (x instanceof Integer)
			return true;
		if (!(x instanceof String))
			return false;
		try {
			int i3 = Integer.parseInt((String) x);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static Object soustraire(Object x, Object y) {
		if(isNumeric(x) && isNumeric(y)) {
			return (Integer)x - (Integer)y;
		} else {
			return x + "-" + y;
		}
	}
}
