public class Box {
    private boolean hasBomb;
    private boolean revealed;
    String currentIcon = "\u25A0";

    public String getCurrentIcon() {
        return currentIcon;
    }

    public void setCurrentIcon(String currentIcon) {
        this.currentIcon = currentIcon;
    }

    public Box() {
        this.hasBomb = false;
        this.revealed = false;
    }

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
