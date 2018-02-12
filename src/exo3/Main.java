package exercice3;

public class Main {
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
		
		matrice[2][0] = "a2";
		matrice[2][1] = "b2";
		matrice[2][2] = "c2";
		matrice[2][3] = "d2";
		matrice[2][4] = "e2";
		
		matrice[3][0] = "a3";
		matrice[3][1] = "b3";
		matrice[3][2] = "c3";
		matrice[3][3] = "d3";
		matrice[3][4] = "e3";
		
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
		//Une fois les 0 apparues
		
		System.out.println("\n\n\n");
		
		
		afficherMatrice(sousMatrice(matrice,1,1));	
	}
	public static String[][] sousMatrice(String matrice[][], int x, int y){
		String sMatrice[][] = new String[matrice[0].length-1][matrice[0].length-1];
		int sMatI = 0, sMatJ = 0;
		for(int i = x; i < matrice.length; i++) {
			for(int j = y; j < matrice.length; j++) {
				sMatrice[sMatJ][sMatI] = matrice[i][j];
				sMatI++;
			}
			sMatI = 0;
			sMatJ++;
		}
		return sMatrice;
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
	
	public static boolean isNumeric(String str) {
		try {
			int i = Integer.parseInt(str);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
