
public class ComplexNumber {
	public double re;
	public double im;
	
	public ComplexNumber(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public double getMagnitude() {
		return Math.sqrt(getMagnitudeSquared());
	}
	
	public double getMagnitudeSquared() {
		return re * re + im * im;
	}
	
	public void add(ComplexNumber c) {
		re += c.re;
		im += c.im;
	}
	
	public void mult(ComplexNumber c) {
		double r = re * c.re - (im * c.im);
		im = im * c.re + re * c.im;
		re = r;
	}
	
	public void square() {
		mult(this);
	}
}
