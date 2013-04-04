package cesf.math;
/**
 * La clase complex es una clase per disposar de nombres complexos.
 * Els nombres complexos tenen una forma de a+bi, és a dir, 3+4i, on la i es l'arrel 
 * quadrada de -1 i base dels nombres imaginaris.
 * 
 * En un  nombre complex hi han diferents parts:
 * la part imaginaria y la part real.
 * La part imaginaria es b y la part real es a.
 * @author Aitor y Pau
 *
 */
public class Complex {
	private final double re;  
	
	private final double im; 
	
	
	/** constructor per defecte, que inicialitza 're' i 'im' a 0.*/
	public Complex() { 
		re = 0; 
		im = 0; 
	}
	/** Constructor que demana dos parametres del tipus double, 
	 * i els asigna a les variables 're' i 'im' */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
    /** en funcio dels valors de les variables esmentades abans, 
     * retorna una representació en cadena de text */
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }

    /** Realitza la operacio que retorna el mòdul del complex entre re i im.
    @return  Complex de coordenades real,imag*/
    public double abs()   { return Math.hypot(re, im); }
    /** Realitza la operacio que retorna la fase (angle) del complex entre re i im
    @return  Complex de coordenades real,imag*/
    public double phase() { return Math.atan2(im, re); }

    /**Funcio que realiza una suma entre dos complexos.Concretament afegeix 
     * un segon complex al resultant de la funcio anterior.
    @param  b
    @return  Complex de coordenades real,imag*/
    
    public Complex add(Complex b) {
        double real = this.re + b.re;
        double imag = this.im + b.im;
        return new Complex(real, imag);
    }

    /**Funcio que realiza una resta entre dos complexos.Concretament resta 
     * un segon complex al resultant de la funcio anterior.
    @param  b
    @return  Complex de coordenades real,imag*/    
    public Complex substract(Complex b) {
        double real = this.re - b.re;
        double imag = this.im - b.im;
        return new Complex(real, imag);
    }

    /**Funcio que realiza una multiplicacio entre dos complexos.Concretament multiplica 
     * un segon complex al resultat de la funcio anterior.
    @param  b
   @return  Complex de coordenades real,imag*/
    public Complex multiply(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }


    /**Funcio que realiza una multiplicacio entre un nombre complex, i un de real.
    @param  x
    @return  Complex de coordenades real,imag*/
    public Complex multiply(double x) {
    	double real = x * this.re;
    	double imag = x * this.im;
        return new Complex(real, imag);
    }


    /**Funcio que realiza una divisio entre dos complexos.Concretament divideix
     * un segon complex al resultat de la funcio anterior.
    @param  b*/
    public Complex divide(Complex b) {
        return this.multiply(b.reciprocal());
    }

    /**Retorna el complex conjugat de l'actual
     * @return  el complex resultat de la operacio*/
    public Complex conjugate() {
    	return new Complex(this.re, -this.im); 
    }

    /** Retorna el recíproc d'aquest complex
     * @return  el complex reciproc de la operacio*/
    public Complex reciprocal() {
        double x = this.re * this.re + this.im * this.im;
        return new Complex(this.re / x, -this.im / x);
    }

    /** getters*/
    public double getReal() { return this.re; }
    public double getImag() { return this.im; }

    /** Retorna l'exponenciació del complex
     * @return  un nou complex resultant de la operacio*/
    public Complex exp() {
    	double real = Math.exp(this.re) * Math.cos(this.im);
    	double imag = Math.exp(this.re) * Math.sin(this.im);
        return new Complex(real, imag);
    }

    /** Retorna el sinus del complex
     * @return  un nou complex resultant de la operacio de sinus*/
    public Complex sin() {
    	double real = Math.sin(re) * Math.cosh(im);
    	double imag = Math.cos(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    /** Retorna el cosinus del complex
     * 
     *  * @return  un nou complex resultant de la operacio de cosinus*/
     
    public Complex cos() {
    	double real = Math.cos(re) * Math.cosh(im);
    	double imag = -Math.sin(re) * Math.sinh(im);
        return new Complex(real, imag);
    }

    /** Retorna la tangent del complex
     * 
      * @return  un nou complex resultant de la operacio de tangent*/
    public Complex tan() {
        return sin().divide(cos());
    }
    
    /** versió estàtica de la funció suma
     * 
     * @param a
     * @param b
     * @return  un nou complex resultant de la operacio*/
    
    public static Complex add(Complex a, Complex b) {
        double real = a.re + b.re;
        double imag = a.im + b.im;
        return new Complex(real, imag);
    }


}
