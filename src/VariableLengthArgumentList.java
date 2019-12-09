
public class VariableLengthArgumentList {
    public static void main(String[] args) {
        System.out.println("Product 1*2*3 is "+product(1,2,3));
        System.out.println("Product 1*8*7*9*33 is "+product(1,8,7,9,33));
    }

    public static double product(int... a) {
        int product = 1;
        for (int i : a)
            product = product * i;
        return product;
    }

}
