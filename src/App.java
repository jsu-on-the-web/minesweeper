public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Grid grid = new Grid(10, 10);
        System.out.println("This is the grid");
        grid.renderGrid(grid);
        grid.generateBombs();
        System.out.println("This is the grid + bomb locations");
        grid.renderBombLocations(grid);
    }
}
