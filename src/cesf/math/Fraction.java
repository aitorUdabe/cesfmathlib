package cesf.math;

// classe immutable per a representar fraccions enteres

/**
 * La clase fraction es una clase per representar fraccions enteres.
 * les fraccions consten de numerador (variable num) i d'un denominador ( variable den)
 * @author Aitor y Pau
 *
 */
public class Fraction {

	private final int num;
	private final int den;
	
	/** constructor per defecte que inicialitza les variables num i den.
	 * @param num, den
	 */
	public Fraction() { 
		num=0; 
		den=1;
	}
	// constructor amb paràmetres 
	
	/**
	 * Constructor amb condicions. El "den" no pot er 0.
	 */
	public Fraction(int num, int den) { 
		if (den == 0) 
			throw new IllegalArgumentException("Denominator can not be zero!"); 
		this.num = num;
		this.den = den; 
	}

	/**
	 * funcio que retorna el valor del numerador i el del denominador.
	 * @return num, den
	 */
	public int getNum() { return this.num; }
	public int getDen() { return this.den; }
	
	/**retorna el valor enter o decimal que correspon a la fracció.
	 * @return x
	 */
	public double valueOf() {
		double x = (double)(this.num) / this.den; 
		return x;
	}
	
	// retorna el valor numèric d'una fracció (versió estàtica)
	public static double valueOf(Fraction a) {
		double x = (double)(a.num) / a.den; 
		return x;		
	}
	
	/** representa la fracció en una cadena de text
	 * @return num + "/" + den
	 */
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	/**funcio que simplifica una fracció al màxim
	 * @return Fraction(n, d)
	 */
	public Fraction reduce() {
		int mcd = mcd(this.num, this.den);
		int n = this.num / mcd;
		int d = this.den / mcd;
		if (d < 0) { n = -n; d = -d; }
		return new Fraction(n, d);
	}
	
	/** retorna F1 + F2, on tant F1, com F2 son fraccions(suma de fraccions).
	 * @return F1 + F2
	 * @param b
	 */
	public Fraction add(Fraction b) {
		int n = this.num * b.den + this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/** retorna F1 - F2, on tant F1, com F2 son fraccions(resta de fraccions).
	 * @return F1 - F2
	 *  @param b
	 */
	public Fraction substract(Fraction b) {
		int n = this.num * b.den - this.den * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/** retorna F1 * F2, on tant F1, com F2 son fraccions(multiplicacio de fraccions).
	 * @return F1 * F2
	 *  @param b
	 */
	public Fraction multiply(Fraction b) {
		int n = this.num * b.num;
		int d = this.den * b.den;
		return new Fraction(n, d).reduce();
	}
	
	/** retorna F1 * X, on F1 es una fraccio i X es un nombre enter.
	 * @return F1 * X
	 *  @param x
	 */
	public Fraction multiply(int x) {
		int n = this.num * x;
		int d = this.den;
		return new Fraction(n, d).reduce();
	}
	
	/**(divisio de fraccions) Retorna F1 / F2, on tant F1, com F2 son fraccions.
	 * @return F1 / F2
	 *  @param b
	 */
	public Fraction divide(Fraction b) {
		return this.multiply(b.reciprocal());
	}

	/** Retorna el resultat de la operacio 1/F, on F es una fraccio.
	 * 
	 */
	public Fraction reciprocal() {
		return new Fraction(this.den, this.num).reduce();
	}
	
	/** troba el MCD del numerador i denominador
	 * @params a,b
	 */
	protected int mcd(int a, int b) {
		int d; 
		while (b != 0) {
			d = b;
			b = a % b;
			a = d;
		}
		return a;
	}

	/** compara dos fraccions
	 * @params b
	 */ 
	public boolean equals(Fraction b) {
		Fraction f1 = this.reduce();
		Fraction f2 = b.reduce();
		if (f1.num != f2.num) return false;
		if (f1.den != f2.den) return false; 
		return true;
	}
}