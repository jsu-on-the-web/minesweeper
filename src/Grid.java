public class Grid {
    public static int rows;

    public static int cols;

    final static int MINES = 10;

    // For keeping track of how many bombs are adjacent to a cell to render in the cell's place 
    private int bombTally = 0;

    private String[][] grid;

    
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
    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        if (rows > 0) {
            Grid.rows = rows;
        }
    }

    public static int getCols() {
        return cols;
    }

    public static void setCols(int cols) {
        if (cols > 0) {
            Grid.cols = cols;
        }
    }

    /**--------------------------------------------
     *               METHODS
     *---------------------------------------------**/
    public void renderGrid(int[][] gridToRender) {
        for (int i = 0; i < gridToRender.length; i++) {
            for (int j = 0; j < gridToRender[i].length; j++) {
                System.out.print(gridToRender[i][j] + " ");
            }
            System.out.println();
        }
    }
}
