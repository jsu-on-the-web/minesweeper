public class Grid {
    private int rows = 10;

    private int cols = 10;

    private int mines = 10;

    // For keeping track of how many bombs are adjacent to a cell to render in the
    // cell's place
    private int bombTally = 0;

    private int nonBombsLeft;

    private Box[][] grid;
    // private String[][] visibleGrid;
    // private boolean[][] bombLocationGrid;

    /**
     * --------------------------------------------
     * CONSTRUCTORS
     * ---------------------------------------------
     **/

    Grid(int rows, int cols, int mines) {
        setRows(rows);
        setCols(cols);
        setMines(mines);
        grid = new Box[rows][cols];

        // Setting all the initial values of the grid to ■
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Box();
                grid[i][j].currentIcon = "\u25A0";
            }
        }

        generateBombs();

        setNonBombsLeft(rows * cols - mines);
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
        if (rows < 0) {
            throw new IllegalArgumentException("Rows cannot be negative");
        } else {
            this.rows = rows;
        }
    }

    public int getCols() {
        return this.cols;
    }

    public void setCols(int cols) {
        if (cols < 0) {
            throw new IllegalArgumentException("Columns cannot be negative");
        } else {
            this.cols = cols;
        }
    }

    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        if (mines < 0) {
            throw new IllegalArgumentException("Mines cannot be negative");
        } else {
            this.mines = mines;
        }
    }

    public Box getBox(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return null;
        }

        return grid[row][col];
    }

    public int getBombTally() {
        return bombTally;
    }

    public void setBombTally(int bombTally) {
        this.bombTally = bombTally;
    }

    public int getNonBombsLeft() {
        return nonBombsLeft;
    }

    public void setNonBombsLeft(int nonBombsLeft) {
        if (nonBombsLeft < 0) {
            this.nonBombsLeft = 0;
        } else {
            this.nonBombsLeft = nonBombsLeft;
        }
    }

    /**
     * --------------------------------------------
     * METHODS
     * ---------------------------------------------
     **/

    /**
     * Renders the grid by printing it to the console.
     *
     * @param gridToRender the grid to be rendered
     */
    public void renderGrid(Grid gridToRender) {
        // +1 since we have to render the indicators for the x-coordinates too
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < gridToRender.grid.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridToRender.grid[i].length; j++) {
                System.out.print(gridToRender.grid[i][j].currentIcon + " ");
            }
            System.out.println();
        }
    }

    /**
     * Renders the bomb locations on the grid.
     *
     * @param gridToRender the grid to be rendered
     */
    public void renderBombLocations(Grid gridToRender) {
        // +1 since we have to render the indicators for the x-coordinates too
        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < gridToRender.grid.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridToRender.grid[i].length; j++) {
                if (gridToRender.grid[i][j].isHasBomb() == true) {
                    System.out.print("X ");
                } else {
                    System.out.print(gridToRender.grid[i][j].currentIcon + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Generates bombs for the game.
     *
     * @param None
     * @return None
     */
    public void generateBombs() {
        for (int i = 0; i < mines; i++) {
            int bombRow;
            int bombCol;

            // Keep generating coords until they're in bounds
            do {
                bombRow = (int) (Math.random() * rows);
                bombCol = (int) (Math.random() * cols);
            } while (bombRow >= rows || bombCol >= cols);

            if (grid[bombRow][bombCol].isHasBomb()) {
                i--; // Ignore this bomb roll
            } else {
                addBomb(bombRow, bombCol);
            }
        }
    }

    /**
     * Adds a bomb to the specified location on the grid.
     *
     * @param row the row index of the bomb location
     * @param col the column index of the bomb location
     */
    public void addBomb(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        grid[row][col].setHasBomb(true);
    }

    /**
     * Checks if there is an adjacent bomb at the specified row and column.
     *
     * @param row the row index of the grid
     * @param col the column index of the grid
     * @return true if there is an adjacent bomb, false otherwise
     */
    public boolean checkForAdjacentBomb(int row, int col) {
        if (!isValidBoxLocation(row, col)) {
            return false;
        }
        bombTally = 0; // reseting the bomb tally

        // Coordinates for iterating through the grid
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) { 
            int x = row + dx[i];
            int y = col + dy[i];

            // Check that the current grid square being checked is in bounds
            if (!isValidBoxLocation(x, y)) {
                continue; // skip over this box, go to the next one
            }

            if (grid[x][y].isHasBomb()) {
                bombTally++;
            }
        }
        return true; 
    }

        /**
     * Recursive method to reveal all adjacent empty boxes.
     *
     * @param row the row index of the current box
     * @param col the column index of the current box
     */
    public void revealAdjacentEmptyBoxes(int row, int col) {
        // Coordinates for iterating through the grid
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int x = row + dx[i];
            int y = col + dy[i];

            // Check that the current grid square being checked is within the grid bounds
            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                Box currentBox = grid[x][y];

                // Check if the box is not already revealed
                if (!currentBox.isRevealed()) {
                    // Mark the box as revealed and update its current icon
                    currentBox.setRevealed(true);
                    checkForAdjacentBomb(x, y);
                    currentBox.setCurrentIcon(getBombTally() + "");

                    // If the revealed box is also empty, continue revealing its adjacent empty boxes
                    if (getBombTally() == 0) {
                        revealAdjacentEmptyBoxes(x, y);
                    }
                }
            }
        }
    }


    public boolean isValidBoxLocation(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }
        return true;
    }
}
