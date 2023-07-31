import java.util.Scanner;

public class App {

    /**------------------------------------------------------------------------
     *                           VARIABLES
     *------------------------------------------------------------------------**/

     /**--------------------------------------------
      *               TITLES
      *---------------------------------------------**/

      public static final String setupMessage = "    ____       ____                                         __             __     \n" +
      "   / __ )___  / __/___  ________     _      _____     _____/ /_____ ______/ /_    \n" +
      "  / __  / _ \\/ /_/ __ \\/ ___/ _ \\   | | /| / / _ \\   / ___/ __/ __ `/ ___/ __/    \n" +
      " / /_/ /  __/ __/ /_/ / /  /  __/   | |/ |/ /  __/  (__  ) /_/ /_/ / /  / /__ _ _ \n" +
      "/_____/\\___/_/  \\____/_/   \\___/    |__/|__/\\___/  /____/\\__/\\__,_/_/   \\__(_|_|_)";

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
        // * Setup, grab size and mines from the player
        Scanner scanner = new Scanner(System.in);
        System.out.println(setupMessage);
        System.out.println("Welcome to Minesweeper.java! Let's get some details to make this session perfect for you.");
        System.out.println("How big do you want the grid to be?");
        int rowsAndCols = scanner.nextInt();
        System.out.println("How many mines should there be? \n (We recommend this to be the same as the grid size you entered before.)");
        int minesAmount = scanner.nextInt();
        
        Grid grid = new Grid(rowsAndCols, rowsAndCols, minesAmount);
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
