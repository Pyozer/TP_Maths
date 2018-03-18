package exo5;

import java.util.ArrayList;
import java.util.Scanner;

import exo2.Main2;
import exo4.Main4;
import utils.Matrice;
import utils.Saisie;

public class Main5 {
	private static int taille = 0;
	private static Double[][] matrice;
	private static Double[] result;
	
	private static double determinant = 0;
	public static void main(String []args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le nombre d'equations du systeme : ");
		taille = in.nextInt();
		
		matrice = new Double[taille][taille];
		result = new Double[taille];
		
		//On creer la matrice de l'equation
		for(int i = 0 ; i < taille ; i++) {
			String line = "";
			for(int j = 0 ; j < taille + 1 ; j++) {
				if(j < taille) {
					System.out.println("Entrez le nombre "+(char)(120 + j));
					double val = (double)in.nextInt();
					matrice[i][j] = val;
					
					if(line.length() != 0) line += "+"+val +""+(char)(120 + j);
					else line += val +""+(char)(120 + j);
					
				}else {
					System.out.println("Entrez le resultat  "+line+"= ?");
					result[i] = (double)in.nextInt();
				}
			}
		}
		//On test si la equation est de cramer
		if((determinant = Main2.calculDetermMatrice(matrice)) != 0) {
			System.out.println("L'equation est un system de cramer");
			
			System.out.println("A-1 : ");
			Matrice.afficherMatrice(Main4.inverserMatrice(matrice));
			
			Double[] sol = new Double[taille];
			for(int i = 0 ; i < taille ; i ++) {
				sol[i] = calculerSolution(i);
			}
			String resu = "La solution unique de Sn est le couple (";
			for(Double d : sol) {
				if(resu.length() > "La solution unique de Sn est le couple (".length())resu += ","+d;
				else resu += d;
			}
			resu += ")";
			System.out.println(resu);
		}else {
			System.out.println("Pas de cramer");
		}
	}
	private static Double calculerSolution(int i) {
		Double[][] temp = Matrice.copierMatrice(matrice);
		for(int x = 0 ; x < taille ; x++) {
			temp[x][i] = result[x];
		}
		return Main2.calculDetermMatrice(temp)/determinant;
	}
}
