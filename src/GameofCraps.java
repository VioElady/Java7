import java.util.Random;

public class GameofCraps {
    private Random randomNumbers = new Random();

    private enum Status {Continue, Won, Lost}

    int[] GamesWon;
    int[] GamesLost;
    int winTotal;
    int loseTotal;

    public void play() {

        int totalOfDice = 0;
        int myPoints = 0;

        Status gameStatus;
        int roll;
        GamesWon = new int[22];
        GamesLost = new int[22];

        for (int x = 1; x <= 1000; x++) {
            totalOfDice = rollDice();
            roll = 1;
            switch (totalOfDice) {

                case 7:
                case 11:
                    gameStatus = Status.Won;
                    break;
                case 2:
                case 3:
                case 12:
                    gameStatus = Status.Lost;
                    break;
                default:
                    gameStatus = Status.Continue;
                    myPoints = totalOfDice;
                    break;
            }

            while (gameStatus == Status.Continue) {
                totalOfDice = rollDice();
                roll++;
                if (totalOfDice == myPoints)

                    gameStatus = Status.Won;
                else if (totalOfDice == 7)
                    gameStatus = Status.Lost;

            }

            if (roll > 21)
                roll = 21;

            if (gameStatus == Status.Won) {
                GamesWon[roll]++;
                winTotal++;

            } else {
                GamesLost[roll]++;
                loseTotal++;
            }
        }
        printStats();
    }

    public void printStats() {
        int totalGames = winTotal + loseTotal;
        int length = 0;
        int RollsToWin;
        int RollsToLose;
        for (int x = 1; x <= 21; x++) {

            if (x == 21)
                System.out.printf("\n%d games won and %d games lost on rolls after the 20th roll", GamesWon[21], GamesLost[21]);

            else if (x <= 21)
                System.out.printf("\n%d games won and %d games lost on roll %d", GamesWon[x], GamesLost[x], x);


            RollsToWin = (GamesWon[x] * x);
            RollsToLose = (GamesLost[x] * x);
            System.out.printf("\nTotal Rolls to win: " + RollsToWin);

        }

        System.out.printf("\n%s %d / %d = %.2f%%\n", "The chances of winning are", winTotal, totalGames, (100.0 * winTotal / totalGames));
        System.out.printf("The average game length is %.2f rolls.\n", ((double) length / totalGames));

    }

    public int rollDice() {
        int die1 = 1 + randomNumbers.nextInt(6);
        int die2 = 1 + randomNumbers.nextInt(6);
        int sum = die1 + die2;
        return sum;
    }
    public static void main(String args[]) {
        GameofCraps game = new GameofCraps();
        game.play();
    }
}