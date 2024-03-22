public class Conversions {
    public static double footToMeter(double foot) {
        double meter = 0.305 * foot;
        return meter;
    }

    public static double meterToFoot(double meter) {
        double foot = 3.279 * meter;
        return foot;
    }
    public static void main(String[] args) {
        for (double e = 1; e <= 10; e++) {
            double meter = footToMeter(e);
            System.out.println(e + " feet = " + meter + " meters.");
        }
        for (double e = 20; e <= 65; e += 5) {
            double foot = meterToFoot(e);
            System.out.println(e + " meters = " + foot + " feet.");
        }
    }
}