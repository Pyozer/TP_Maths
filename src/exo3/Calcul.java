package exo3;

import java.util.ArrayList;
import java.util.List;

public class Calcul{
	private List<Letter> calcul = new ArrayList<>();
	public Calcul() {
		super();
	}
	public Calcul(Letter l) {
		super();
		calcul.add(l);
	}
	public void addLetter(Letter l) {
		calcul.add(l);
	}
	public String toString() {
		String result = null;
		for(Letter l : calcul) {
			result += l.toString();
		}
		return result;
	}
}
