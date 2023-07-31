import java.util.Scanner;

public class App {

    /**------------------------------------------------------------------------
     *                           VARIABLES
     *------------------------------------------------------------------------**/

     /**--------------------------------------------
      *               TITLES
      *---------------------------------------------**/

      public static final String loseMessage = "__  __               __                       \n"
    + "\\ \\/ /___  __  __   / /   ____  ________      \n"
    + " \\  / __ \\/ / / /  / /   / __ \\/ ___/ _ \\     \n"
    + " / / /_/ / /_/ /  / /___/ /_/ (__  )  __/ _ _ \n"
    + "/_/\\____/\\__,_/  /_____/\\____/____/\\___(_|_|_)";

public static final String winMessage = "__  __               _       ___       __\n" +
    "\\ \\/ /___  __  __   | |     / (_)___  / /\n" +
    " \\  / __ \\/ / / /   | | /| / / / __ \\/ / \n" +
    " / / /_/ / /_/ /    | |/ |/ / / / / /_/  \n" +
    "/_/\\____/\\__,_/     |__/|__/_/_/ /_(_)";

//**-----------------------------------------------------------------------

    public static void main(String[] args) throws Exception {
        Grid grid = new Grid(10, 10);
        GameLogic game = new GameLogic(grid);

        game.playGame();

        // System.out.println("This is the grid");
        // grid.renderGrid(grid);
        // System.out.println("This is the grid + bomb locations");
        // grid.renderBombLocations(grid);

        // * Check for win and lose conditions

        // Win?
        if (game.isPlayerWon()) {
            System.out.println(winMessage);
            grid.renderBombLocations(grid);
            System.out.println("Thanks for playing!");
        } else {
            System.out.println(loseMessage);
            grid.renderBombLocations(grid);
            System.out.println("Better luck next time!");
        }

        // // Win?
        // if (game.checkIfAllBoxesChecked()) {
        // game.setGameEnded(true);
        // game.setPlayerWon(true);
        // }

        // // Lose?
        // if (game.isGameEnded() && !game.isPlayerWon()) {
        // game.setGameEnded(true);
        // game.setPlayerWon(false);
        // }
    }
}
