public class Box {
    private boolean hasBomb;
    private boolean revealed;

    public Box(boolean hasBomb, boolean revealed) {
        this.hasBomb = hasBomb;
        this.revealed = revealed;
    }

    /**
     * --------------------------------------------
     * GETTERS AND SETTERS
     * ---------------------------------------------
     **/

    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
