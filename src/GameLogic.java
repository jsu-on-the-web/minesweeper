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

    /**
     * --------------------------------------------
     * GAME LOGIC
     * ---------------------------------------------
     **/

    public void playGame() {
        // Setting up input
        Scanner scanner = new Scanner(System.in);
        while (!gameEnded) {
            // We should render the grid on every turn
            grid.renderGrid(grid);
            // grid.renderBombLocations(grid);

            // Grabbing input and trying to parse it as a
            System.out.println("Enter the row and column of the box you want to reveal.");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            pickBox(row, col);

            // * Check for win and lose conditions

            if (checkIfAllBoxesChecked()) {
                gameEnded = true;
                playerWon = true;
            }
        }
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
        if (grid.getBox(row, col).isRevealed() != false && grid.getBox(row, col).isHasBomb()) {
            grid.getBox(row, col).setCurrentIcon("X");
            playerWon = false;
            gameEnded = true;
            return true;
        } else {
            // * Else it must be a regular box
            grid.getBox(row, col).setRevealed(true);
            grid.checkForAdjacentBomb(row, col); // ? Try implementing a cascading function?
            grid.getBox(row, col).currentIcon = grid.getBombTally() + "";
            return true;
        }
    }
}
