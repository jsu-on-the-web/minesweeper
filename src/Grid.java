public class Grid {
    public static int rows;

    public static int cols;

    final static int MINES = 10;

    // For keeping track of how many bombs are adjacent to a cell to render in the cell's place 
    private int bombTally = 0;


    
    /**--------------------------------------------
     *               CONSTRUCTORS
     *---------------------------------------------**/

    Grid(int rows, int cols) {
        setRows(rows);
        setCols(cols);
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
}
