import java.util.Scanner;

public class TestRational{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        Rational a;
        Rational b;

        System.out.println("Enter numerator for the first rational number: ");
        int numa = input.nextInt();
        System.out.println("Enter a non-zero denominator for the first rational number: ");
        int denoma = input.nextInt();
        System.out.println("Enter a numerator for the second rational number: ");
        int numb = input.nextInt();
        System.out.println("Enter a non-zero denominator for the second rational number: ");
        int denomb = input.nextInt();

        a = new Rational(numa, denoma);
        b = new Rational(numb, denomb);

        System.out.println("First rational number is: " + a);
        System.out.println("Second rational number is: " + b);
        System.out.println("\n---------------- Addition -----------------");
        System.out.println("Addition of the rational number is: " + a.add(b));
        System.out.println("\n---------------- Subtraction -----------------");
        System.out.println("Subtraction of the rational number is: " + a.subtract(b));
        System.out.println("\n---------------- Multiplication -----------------");
        System.out.println("Multiplication of the rational number is: " + a.multiply(b));
        System.out.println("\n---------------- Division -----------------");
        System.out.println("Division of the rational number is: " + a.divide(b));

        System.out.println(a.toString());
        System.out.println(b.toString());
        
        // Return a String representation of a Rational number in floating-point format.
        // Providing formatting capabilities that enable the user of the class to specify the
        // number of digits of precision to the right of the decimal point.
        System.out.println("\n **** A String representation of a Rational number in floating-point format. *** ");
        System.out.print("Specify the number of digits of precision to the right of the decimal point: ");
        System.out.println("\nEnter numerator for the first rational number: ");
        int numFraction = input.nextInt();
        System.out.println("Floating-point String representation of a Rational number " + a + " (up to "+numFraction+") : " + a.toFloatString(numFraction));
        System.out.println("Enter numerator for the second rational number: ");
        int numFraction2 = input.nextInt();
        System.out.println("Floating-point String representation of a Rational number " + b + " (up to "+numFraction2+") : " + b.toFloatString(numFraction2));
    }
    
}
