import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.valueOf(0);
    private BigInteger denominator = BigInteger.valueOf(1);

    /** Construct a rational with default properties */
    public Rational() {
    }

    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
      long gcd = gcd(numerator.longValue(), denominator.longValue());
      this.numerator = BigInteger.valueOf((denominator.longValue() > 0 ? 1 : -1) * numerator.longValue() / gcd);
      this.denominator = BigInteger.valueOf(Math.abs(denominator.longValue()) / gcd);
    }

    /** Find GCD of two numbers */
    private static long gcd(long n, long d) {
      long n1 = Math.abs(n);
      long n2 = Math.abs(d);
      int gcd = 1;

      for (int k = 1; k <= n1 && k <= n2; k++) {
        if (n1 % k == 0 && n2 % k == 0)
          gcd = k;
      }

      return gcd;
    }

    /** Return numerator */
    public BigInteger getNumerator() {
      return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
      return denominator;
    }

    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }

    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }

    /** Multiply a rational number by this rational */
    public Rational multiply(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getNumerator());
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }

    /** Divide a rational number by this rational */
    public Rational divide(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator());
      BigInteger d = denominator.multiply(secondRational.numerator);
      return new Rational(n, d);
    }

    @Override
    public String toString() {
      if (denominator.longValue() == 1)
        return numerator + "";
      else
        return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
      if ((this.subtract((Rational)(other))).getNumerator().intValue() == 0)
        return true;
      else
        return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
      return (int)doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
      return (float)doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
      return numerator.longValue() *  1.0 / denominator.longValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
      return (long)doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
      if (this.subtract(o).getNumerator().intValue() > 0)
        return 1;
      else if (this.subtract(o).getNumerator().intValue() < 0)
        return -1;
      else
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first rational number:");
        int n1 = sc.nextInt();
        int d1 = sc.nextInt();
        Rational rational1 = new Rational(BigInteger.valueOf(n1), BigInteger.valueOf(d1));
        System.out.println("Enter the second rational number:");
        int n2 = sc.nextInt();
        int d2 = sc.nextInt();
        sc.close();
        Rational rational2 = new Rational(BigInteger.valueOf(n2), BigInteger.valueOf(d2));
        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        System.out.println(rational2 + " is " + rational2.doubleValue());
    }
  }
