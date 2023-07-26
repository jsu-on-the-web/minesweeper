public class Grid {
    public int rows = 10;

    public int cols = 10;

    final int MINES = 10;

    // For keeping track of how many bombs are adjacent to a cell to render in the
    // cell's place
    private int bombTally = 0;

    private String[][] visibleGrid;
    private boolean[][] bombLocationGrid;

    /**
     * --------------------------------------------
     * CONSTRUCTORS
     * ---------------------------------------------
     **/

    Grid(int rows, int cols) {
        setRows(rows);
        setCols(cols);
        visibleGrid = new String[rows][cols];
        bombLocationGrid = new boolean[rows][cols];

        // Setting all the initial values of the grid to ■
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visibleGrid[i][j] = "\u25A0";
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                bombLocationGrid[i][j] = false;
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

    public String[][] getVisibleGrid() {
        return visibleGrid;
    }

    public void setVisibleGrid(String[][] grid) {
        this.visibleGrid = grid;
    }

    public boolean[][] getBombLocationGrid() {
        return bombLocationGrid;
    }

    public void setBombLocationGrid(boolean[][] bombLocationGrid) {
        this.bombLocationGrid = bombLocationGrid;
    }

    /**
     * --------------------------------------------
     * METHODS
     * ---------------------------------------------
     **/
    public void renderGrid(Grid gridToRender) {
        // +1 since we have to render the indicators for the x-coordinates too
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < gridToRender.getVisibleGrid().length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridToRender.getVisibleGrid()[i].length; j++) {
                System.out.print(gridToRender.getVisibleGrid()[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void renderBombLocations(Grid gridToRender) {
        // +1 since we have to render the indicators for the x-coordinates too
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < gridToRender.getBombLocationGrid().length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridToRender.getBombLocationGrid()[i].length; j++) {
                if (gridToRender.getBombLocationGrid()[i][j] == true) {
                    System.out.print("X ");
                } else {
                    System.out.print("\u25A0 ");
                }
            }
            System.out.println();
        }
    }

    public void generateBombs() {
        for (int i = 0; i < MINES; i++) {
            int bombRow;
            int bombCol;

            // Keep generating coords until they're in bounds
            do {
                bombRow = (int) (Math.random() * rows);
                bombCol = (int) (Math.random() * cols);
            } while (bombRow >= rows || bombCol >= cols);

            if (bombLocationGrid[bombRow][bombCol] == true) {
                i--; // Ignore this bomb roll
            } else {
                addBomb(bombRow, bombCol);
            }
        }
    }

    public void addBomb(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        bombLocationGrid[row][col] = true;
    }
}
