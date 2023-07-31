import java.util.Scanner;

public class GameLogic {
    /**
     * ------------------------------------------------------------------------
     * VARIABLES
     * ------------------------------------------------------------------------
     **/
    private Grid grid;
    private boolean gameEnded = false;
    private boolean playerWon;

    /**--------------------------------------------
     *               TITLES
     *---------------------------------------------**/

     public static final String title = " __   __  ___   __    _  _______  _______  _     _  _______  _______  _______  _______  ______   \n"
     + "|  |_|  ||   | |  |  | ||       ||       || | _ | ||       ||       ||       ||       ||    _ |  \n"
     + "|       ||   | |   |_| ||    ___||  _____|| || || ||    ___||    ___||    _  ||    ___||   | ||  \n"
     + "|       ||   | |       ||   |___ | |_____ |       ||   |___ |   |___ |   |_| ||   |___ |   |_||_ \n"
     + "|       ||   | |  _    ||    ___||_____  ||       ||    ___||    ___||    ___||    ___||    __  |\n"
     + "| ||_|| ||   | | | |   ||   |___  _____| ||   _   ||   |___ |   |___ |   |    |   |___ |   |  | |\n"
     + "|_|   |_||___| |_|  |__||_______||_______||__| |__||_______||_______||___|    |_______||___|  |_|\n";

    /**
     * ------------------------------------------------------------------------
     * METHODS
     * ------------------------------------------------------------------------
     **/
    public GameLogic(Grid grid) {
        this.grid = grid;
    }

    /**
     * --------------------------------------------
     * GETTERS AND SETTERS
     * ---------------------------------------------
     **/

    public boolean isGameEnded() {
        return gameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        this.gameEnded = gameEnded;
    }

        public boolean isPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }


    /**
     * --------------------------------------------
     * GAME LOGIC
     * ---------------------------------------------
     **/

    public void playGame() {
        // Setting up input
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            clearScreen();
            System.out.println(title);
            // We should render the grid on every turn
            grid.renderGrid(grid);
            // grid.renderBombLocations(grid);

            // Grabbing input and trying to parse it as a
            System.out.println("Enter the row and column of the box you want to reveal.");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            pickBox(row, col);
        }

        clearScreen(); // One more clear screen for when game is over
    }

    public boolean checkIfAllBoxesChecked() {
        return false;
    }

    /**
     * Checks if a box can be picked.
     *
     * @param  row   the row index of the box
     * @param  col   the column index of the box
     * @return       true if the box can be picked, false otherwise
     */
    public boolean pickBox(int row, int col) {
        // * Guard clauses
        if (grid.getBox(row, col) == null) {
            System.out.println("This box is invalid.");
            return false;
        }

        if (grid.getBox(row, col).isRevealed()) {
            System.out.println("This box is already revealed.");
            return false;
        }

        // * Valid box! Time to check its value.
        return checkBox(row, col);
    }

    /**
     * Checks if there's a bomb at the specified row and column.
     *
     * @param  row  the row index of the box
     * @param  col  the column index of the box
     * @return      true regardless of whether there's a bomb or not
     */
    public boolean checkBox(int row, int col) {
        // * Let's see if there's a bomb
        if (grid.getBox(row, col).isHasBomb()) {
            grid.getBox(row, col).setCurrentIcon("X");
            playerWon = false;
            gameEnded = true;
            return true;
        } else {
            // * Else it must be a regular box
            grid.getBox(row, col).setRevealed(true);
            grid.checkForAdjacentBomb(row, col); // ? Try implementing a cascading function?
            grid.getBox(row, col).currentIcon = grid.getBombTally() + "";
            grid.setNonBombsLeft(grid.getNonBombsLeft() - 1);
            
            if (grid.getBombTally() == 0) {
                grid.revealAdjacentEmptyBoxes(row, col);
            }
    

            return true;
        }
    }

    /**--------------------------------------------
     *               MISC
     *---------------------------------------------**/
    public void clearScreen() {
        System.out.print("\u001b[H\u001b[2J"); // This strange set of characters will clear the terminal on any OS
        System.out.flush();
    }
}
