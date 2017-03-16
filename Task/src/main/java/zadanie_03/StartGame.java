package zadanie_03;

/**
 * Created by Sviatoslav on 15.03.2017.
 */
public class StartGame {
    public static void main(String[] args) {
        GameOfDice game = new GameOfDice();
        try {
            game.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
