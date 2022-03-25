public class Rational {

    private int numerator;
    private int denominator;

    public Rational() {
        numerator = 1;
        denominator = 2;
    }
    public Rational(int numerator, int denominator) {
        int g =gcd(numerator,denominator);
        this.numerator = numerator/g;
        this.denominator = denominator/g;

    }
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    public Rational add(Rational r) {
        int  num = numerator * r.denominator + r.numerator * denominator;
        int denom = denominator * r.denominator;
        return new Rational(num, denom);
    }
    public Rational subtract(Rational r) {
        int num = numerator * r.denominator - r.numerator * denominator;
        int denom = denominator  * r.denominator;
        return new Rational(num, denom);
    }
    public Rational multiply(Rational r) {
        int num = numerator * r.numerator;
        int denom = denominator * r.denominator;
        return  new Rational(num, denom);
    }
    public Rational divide(Rational r) {
        int num = numerator * r.denominator;
        int denom = denominator * r.numerator;
        return new Rational(num, denom);
    }
// reduce fraction
    public static int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

    // 
    
    @Override
    public String toString() {
        return "(" + numerator + "/" + denominator + ")";
    }

    // return floating-point String representation of a Rational number
    public String toFloatString( int digits )
    {
       double value = ( double ) numerator / denominator;
        return String.format( "%." + digits + "f", value );
    } 
}