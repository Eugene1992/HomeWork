package zadanie_03;

/**
 * Created by Sviatoslav on 15.03.2017.
 */
public class Player {
    private String name;
    private int sumTwoDice;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSumTwoDice() {
        return sumTwoDice;
    }

    public void dropDices() {
        int diceOne = 1 + (int) ((Math.random() * 6));
        System.out.print("dice1 = " + diceOne + "; ");
        int diceTwo = 1 + (int) ((Math.random() * 6));
        System.out.print("dice2 = " + diceTwo + ";\n");
        sumTwoDice = diceOne + diceTwo;
    }
}
