
import java.security.SecureRandom;

public class GameofCraps {
    private static final SecureRandom randomNumbers = new SecureRandom();

    private enum Status {CONTINUE, WON, LOST}

    ;
    int[] GamesWon;
    int[] GamesLost;
    int winTotal;
    int loseTotal;


    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private static int roll = 0;

    public static void main(String[] args) {
        getStats();
    }

    public static int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);

        int sum = die1 + die2;
        int count = 0;

        return sum;
    }

    public static Status playCraps() {
        int myPoint = 0;
        Status gameStatus;
        int sumOfDice = 0;

        sumOfDice = rollDice();
        roll = 1;
        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            roll++;
            sumOfDice = rollDice();
            if (sumOfDice == myPoint)
                gameStatus = Status.WON;
            else if (sumOfDice == SEVEN)
                gameStatus = Status.LOST;
        }

        if (gameStatus == Status.WON) {
            return Status.WON;
        } else {
            return Status.LOST;
        }
    }

    public static void getStats() {
        Status gameStatus;
        int[] gamesWon = new int[22];
        int[] gamesLost = new int[22];
        int winTotal = 0;
        int loseTotal = 0;


        for (int i = 0; i < 1000000; i++) {
            gameStatus = playCraps();
            if (roll > 21)
                roll = 21;
            if (gameStatus == Status.WON) {
                gamesWon[roll]++;
                winTotal++;
            } else {
                gamesLost[roll]++;
                loseTotal++;
            }
        }
        int rollsToWon = 0;
        int rollsToLost = 0;
        for (int x = 1; x <= 21; x++) {
            if (x == 21)
                System.out.printf("\n%7d games won and %7d games lost on rolls after the 20th roll", gamesWon[21], gamesLost[21]);
            else if (x <= 21)
                System.out.printf("\n%7d games won and %7d games lost on roll %7d", gamesWon[x], gamesLost[x], x);
            rollsToWon += x * gamesWon[x];
            rollsToLost += x * gamesLost[x];

        }

        int totalGames = 1000000;
        double averageLength = 0.0;
        averageLength = (rollsToLost + rollsToWon + winTotal + loseTotal) / totalGames;

        System.out.println();
        System.out.println("\n\tGames won " + winTotal);
        System.out.println("\tGames lost " + loseTotal);
        System.out.println();
        System.out.printf("\n\t%s %d / %d = %.2f%%\n", "The chances of winning are", winTotal, totalGames, (100.0 * winTotal / totalGames));
        System.out.println();
        System.out.printf("Average length of a game of craps is %.2f", averageLength);
    }
}