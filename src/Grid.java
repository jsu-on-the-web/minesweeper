public class Grid {
    public int rows = 10;

    public int cols = 10;

    final int MINES = 10;

    // For keeping track of how many bombs are adjacent to a cell to render in the cell's place 
    private int bombTally = 0;

    private String[][] grid;

    
    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    /**--------------------------------------------
     *               CONSTRUCTORS
     *---------------------------------------------**/

    Grid(int rows, int cols) {
        setRows(rows);
        setCols(cols);
        grid = new String[rows][cols];

        // Setting all the initial values of the grid to ■
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = "\u25A0";
            }
        }
    }

    /**
     * --------------------------------------------
     * GETTERS AND SETTERS
     * ---------------------------------------------
     **/
    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
        }
    }

    public int getCols() {
        return this.cols;
    }

    public void setCols(int cols) {
        if (cols > 0) {
            this.cols = cols;
        }
    }

    /**--------------------------------------------
     *               METHODS
     *---------------------------------------------**/
    public void renderGrid(Grid gridToRender) {
        // +1 since we have to render the indicators for the x-coordinates too
                System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < gridToRender.getGrid().length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridToRender.getGrid()[i].length; j++) {
                System.out.print(gridToRender.getGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }
}

