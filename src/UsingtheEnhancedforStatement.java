
public class UsingtheEnhancedforStatement {
    public static void main(String[] args) {

        double suma = 0;
        for (String arg : args) suma += sum(Double.parseDouble(arg));

        System.out.println("Sum is " + suma);
    }
    public static double sum(double... a) {
        double sum = 0;
        for (double i : a)
            sum = sum + i;
        return sum;
    }
}