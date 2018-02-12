package exercice3;

public class main3 {
	public static void main(String[] args) {
		String matrice[][] = new String[5][5];
		matrice[0][0] = "1";
		matrice[0][1] = "1";
		matrice[0][2] = "1";
		matrice[0][3] = "1";
		matrice[0][4] = "1";

		matrice[1][0] = "a";
		matrice[1][1] = "b";
		matrice[1][2] = "c";
		matrice[1][3] = "d";
		matrice[1][4] = "e";

		matrice[2][0] = "a²";
		matrice[2][1] = "b²";
		matrice[2][2] = "c²";
		matrice[2][3] = "d²";
		matrice[2][4] = "e²";

		matrice[3][0] = "a³";
		matrice[3][1] = "b³";
		matrice[3][2] = "c³";
		matrice[3][3] = "d³";
		matrice[3][4] = "e³";

		matrice[4][0] = "a4";
		matrice[4][1] = "b4";
		matrice[4][2] = "c4";
		matrice[4][3] = "d4";
		matrice[4][4] = "e4";


		for(int li = 0 ; li < matrice[0].length ; li++) {
			for(int col = 1 ; col < matrice[0].length; col++) {
				if(isNumeric(matrice[li][col]) && isNumeric(matrice[li][0])) {
					matrice[li][col] = String.valueOf(Integer.parseInt(matrice[li][col]) - Integer.parseInt(matrice[li][0]));
				}else {
					matrice[li][col] = matrice[li][col] + "-" + matrice[li][0];
				}
			}
		}
		afficherMatrice(matrice);
	}
	public static void afficherMatrice(String[][] matrice) {
		final int NBSPACE = 10;

		for(int i = 0 ; i < matrice[0].length; i++) {
			for(int j = 0; j < matrice[0].length ; j ++) {
				String spaces = "";
				for(int nb = 0 ; nb < NBSPACE - matrice[i][j].length() ; nb++) {
					spaces += " ";
				}
				System.out.print(matrice[i][j] + spaces);
			}
			System.out.println();
		}
	}
	public static String

	public static boolean isNumeric(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
