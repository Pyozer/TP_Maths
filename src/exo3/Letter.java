package exercice3;

import java.util.ArrayList;
import java.util.List;

public class Letter {
	private String value;
	private int deg = 1; 
	public Letter(String value) {
		super();
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public Calcul multiply(Letter letter) {
		Calcul result = new Calcul();
		if(this.value.equals(letter.getValue())) {
			this.deg++;
			result.addLetter(this);
		}else {
			result.addLetter(this);
			result.addLetter(letter);
		}
		return result; 
	}
}
