package utils;

public class CompoundInterest {
    public static double getCompoundInterest(double invested, double rate, int month) {
        double finalPrice = invested * Math.pow(1+(rate/100),month); 
        return finalPrice;
    }

}
