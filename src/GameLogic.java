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
        while (!gameEnded) {


        }
    }

    public boolean checkIfAllBoxesChecked() {
        return false;
    }

    public boolean pickBox(int row, int col) {
        if (grid.getBox(row, col) == null) {
            System.out.println("This box is invalid.");
            return false;
        }

        if (grid.getBox(row, col).isRevealed()) {
            System.out.println("This box is already revealed.");
            return false;
        }

        // Let's see if there's a bomb
        if (grid.getBox(row, col).isRevealed() != false && grid.getBox(row, col).isHasBomb()) {
            grid.getBox(row, col).setCurrentIcon("X");
            playerWon = false; 
            gameEnded = true;
            return true;
        }

        // Else it must be a regular box
        grid.getBox(row, col).setRevealed(true);
        
        
        grid.getBox(row, col).currentIcon = grid.getBombTally() + ""; 

    }
}
