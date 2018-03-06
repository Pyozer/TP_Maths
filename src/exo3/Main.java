package exo3;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Matrice;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = "";
		int taille = 0;
		
		//Recuperation de la taille de la matrice
		System.out.println("Entrez la taille de la matrice :");
		do{
			if (isNumeric(line = sc.nextLine().trim().toLowerCase())) break;
		}while(taille < 10);
		taille = Integer.parseInt(line);
		
		//Recuperation des nombres
		String []userInput = new String[taille];
		for(int i = 0 ; i < userInput .length; i++) {
			System.out.println("Enter "+ (char)(97+i)+ " :");
			userInput[i] = sc.nextLine();
		}
		//Creation de la matrice associee
		Object matrice[][] = new Object[taille][taille];
		for(int i = 0 ; i < matrice.length; i++) {
			for(int j = 0 ; j < matrice.length ; j++) {
				matrice[i][j] = puissance(userInput[j], i);
			}
		}
		System.out.println("-------------------Matrice Originelle-------------------");
		Matrice.afficherMatrice(matrice);
		
		//On parcour les colonnes pour soustraire la colonne pivot (1)
		for(int j = 1 ; j < matrice.length; j++) {
			for(int i = 0 ; i < matrice.length ; i++) {
				matrice[i][j] = soustraire(matrice[i][j], matrice[i][0]);
			}
		}
		
		System.out.println("-------------------Matrice Avec 0-------------------");
		Matrice.afficherMatrice(matrice);
		
		
		Matrice.sousMatriceObject(matrice,1,1);
		
	}
	public static Object puissance(Object eq, int puissance) {
		if(isNumeric(eq)) {
			return (int)Math.pow(Integer.parseInt((String)eq), puissance);
		}else {
			if(puissance == 0) {
				return 1;
			}else if(puissance == 1) {
				return eq;
			}else {
				return eq+String.valueOf(puissance);
			}
		}
	}
	public static Object soustraire(Object x1, Object x2) {
		if(isNumeric(x1) && isNumeric(x2)) {
			return Integer.parseInt(x1.toString())- Integer.parseInt(x2.toString());
		} else {
			if(x1.equals(x2)) {
				return 0;
			}
			return x1 + "-" + x2;
		}
	}
	public static String sansPuissance(String eq) {
		return eq.replaceAll("[0-9]", "");
	}
	
	public static String changePuissance(String eq, int newp) {
		String result = eq;
		String[] puissances = eq.replaceAll("[^0-9]+", " ").trim().split(" "); 
		for(int i = 0 ; i < puissances.length ; i++) {
			result.replace(puissances[i], String.valueOf(Integer.parseInt(puissances[i]) - newp));
		}
		return result;
	}
	//Pas opti car test uniquement la premiere
	public static int getPuissance(String eq) {   
		String[] puissance = eq.trim().replaceAll("[^0-9]+", ",").split(","); 
		for(String s : puissance) {
			return Integer.parseInt(s);
		}
		return 1;
	}
	public static boolean isNumeric(Object str) {
		if(str instanceof Integer)return true;
		if(!(str instanceof String))return false;
		try {
			int i3 = Integer.parseInt((String)str);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}

////Parcour de la ligne
//		ArrayList<Object> result = new ArrayList<>();
//		
//		
//		int indexFin = 0;
//		int index = indexFin + 1;
//		while(indexFin <= matrice.length-2) {
//			result.add(soustraire(matrice[1][index], matrice[1][indexFin]));
//			index ++;
//			if(index > matrice.length-1) {
//				indexFin ++;
//				index = indexFin+1;
//			}
//		}
//		
//		//Regarde si l'equation est faisable ou non
//		if(isNumeric(result.get(0))) {
//			int res = 0;
//			for(Object o : result) {
//				res = (int)o;
//			}
//			System.out.print("Determinant : "+res);
//		}else {
//			for(Object o : result) {
//				System.out.print("Determinant : ("+o+")");
//			}
//		}
