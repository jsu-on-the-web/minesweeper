import java.util.Scanner;

public class App {
    public static final String title = 
        " __   __  ___   __    _  _______  _______  _     _  _______  _______  _______  _______  ______   \n"
        + "|  |_|  ||   | |  |  | ||       ||       || | _ | ||       ||       ||       ||       ||    _ |  \n"
        + "|       ||   | |   |_| ||    ___||  _____|| || || ||    ___||    ___||    _  ||    ___||   | ||  \n"
        + "|       ||   | |       ||   |___ | |_____ |       ||   |___ |   |___ |   |_| ||   |___ |   |_||_ \n"
        + "|       ||   | |  _    ||    ___||_____  ||       ||    ___||    ___||    ___||    ___||    __  |\n"
        + "| ||_|| ||   | | | |   ||   |___  _____| ||   _   ||   |___ |   |___ |   |    |   |___ |   |  | |\n"
        + "|_|   |_||___| |_|  |__||_______||_______||__| |__||_______||_______||___|    |_______||___|  |_|\n";

    public static void main(String[] args) throws Exception {
                Grid grid = new Grid(10, 10);
    GameLogic game = new GameLogic(grid);
        
        System.out.println(title);

        // System.out.println("This is the grid");
        // grid.renderGrid(grid);
        // System.out.println("This is the grid + bomb locations");
        // grid.renderBombLocations(grid);

        
            // * Check for win and lose conditions
            
            // // Win?
            // if (game.checkIfAllBoxesChecked()) {
            //     game.setGameEnded(true);
            //     game.setPlayerWon(true);
            // } 

            // // Lose?
            // if (game.isGameEnded() && !game.isPlayerWon()) {
            //     game.setGameEnded(true);
            //     game.setPlayerWon(false);
            // }
    }
}
