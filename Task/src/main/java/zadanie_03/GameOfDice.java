package zadanie_03;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Sviatoslav on 15.03.2017.
 */
public class GameOfDice {

    private BufferedReader reader;
    private Player playerOne;
    private Player playerTwo;
    private int totalSumPlayerOne;
    private int totalSumPlayerTwo;

    public GameOfDice() {
        this.playerOne = new Player("One");
        this.playerTwo = new Player(("Two"));
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setTotalSumPlayerOne(int totalSumPlayerOne) {
        this.totalSumPlayerOne = totalSumPlayerOne;
    }

    public int getTotalSumPlayerOne() {
        return totalSumPlayerOne;
    }

    public void setTotalSumPlayerTwo(int totalSumPlayerTwo) {
        this.totalSumPlayerTwo = totalSumPlayerTwo;
    }

    public int getTotalSumPlayerTwo() {
        return totalSumPlayerTwo;
    }

    public void play() throws Exception {
        int i = 1;
        while (i < 6) {
            System.out.println("\nIf you want to start " + i + " round write \"start\"");
            String answer = reader.readLine();
            if (answer.equals("start")) {
                changePlayer();
                setTotalSumPlayerOne(0);
                setTotalSumPlayerTwo(0);
            }
            i++;
        }
    }

    private void changePlayer() {
        Player[] players = {playerOne, playerTwo};
        for (Player player : players) {
            for (int j = 1; j <= 10; j++) {
                System.out.println("\nPlayer " + player.getName() + " drop the dice " + j + " times");
                player.dropDices();
                totalSumPlayerOne = (totalSumPlayerOne + playerOne.getSumTwoDice() / j);
                totalSumPlayerTwo = (totalSumPlayerTwo + playerTwo.getSumTwoDice() / j);
                if (!sumSevenOrEleven(j, player)) {
                    return;
                } else if (!sumTwoOrTwelve(j, player)) {
                    return;
                }
            }
        }
        finalResult();
    }

    public void finalResult() {
        System.out.println("**********Final Result***********");
        System.out.println("Player " + playerOne.getName() + " has " + getTotalSumPlayerOne());
        System.out.println("Player " + playerTwo.getName() + " has " + getTotalSumPlayerTwo());
        if (getTotalSumPlayerOne() < getTotalSumPlayerTwo()) {
            System.out.println("And winner is ... Player " + playerTwo.getName());
        } else if (getTotalSumPlayerOne() == getTotalSumPlayerTwo()) {
            System.out.println("DRAW!!!");
        } else {
            System.out.println("And winner is ... Player " + playerOne.getName());

        }
    }

    public boolean sumSevenOrEleven(int index, Player player) {
        int sum = player.getSumTwoDice();
        if (index == 1 && (sum == 7 || sum == 5 || sum == 11)) {
            System.out.println("Winner in this round is player" + player.getName() + ". Congratulation!!!\n");
            return false;
        }
        return true;
    }

    public boolean sumTwoOrTwelve(int index, Player player) {
        int sum = player.getSumTwoDice();
        if (index == 1 && (sum == 2 || sum == 12)) {
            System.out.println("Player " + player.getName() + " lost this round");
            return false;
        }
        return true;
    }
}