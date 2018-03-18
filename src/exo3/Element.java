package exo3;

public class Element {
	private Object value;
	private int puissance;
	public Element(Object value, int puissance) {
		super();
		this.value = value;
		this.puissance = puissance;
	}

	public void changePuissance(int newp) {
		this.puissance = newp;
	}
	public int getPuissance() {   
		return this.puissance;
	}
	public boolean isNumeric() {
		if(this.value instanceof Integer)return true;
		if(!(this.value instanceof String))return false;
		try {
			int i3 = Integer.parseInt((String)this.value);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public double numericValue() {
		return Math.pow(Integer.parseInt((String)this.value),this.puissance);
	}
	public String toString() {
		if(this.puissance == 0) {
			return "1";
		}else if (this.puissance == 1 && this.isNumeric() && numericValue() != 0) {
			return String.valueOf(this.value);
		}else {
			return this.value +"^"+this.puissance;
		}
	}
}
