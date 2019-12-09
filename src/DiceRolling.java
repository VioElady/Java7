import java.security.SecureRandom;

public class DiceRolling{
    public final static int ROLLING_TIMES = 36000000;

    public static void main(String[] args) {
        SecureRandom rollFirstDice = new SecureRandom();
        SecureRandom rollSecondDice = new SecureRandom();

        int first;
        int second;
        int[] frequency = new int[36];

        int[] sumOfDice = new int[ROLLING_TIMES];
        for (int i = 0; i < ROLLING_TIMES; i++) {
            first = 1 + rollFirstDice.nextInt(6);
            second = 1 + rollSecondDice.nextInt(6);
            sumOfDice[i] = first + second;
        }

        for (int i = 0; i < sumOfDice.length; i++){
            System.out.printf("");
            ++frequency[sumOfDice[i]];
        }
        System.out.printf("%s%10s%n", "Sum", "Frequency");
        for (int rating = 2; rating < 13; rating++){
            System.out.printf("%6d%10d\n",rating,frequency[rating]);
        }
    }
}