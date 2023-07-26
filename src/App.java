public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Grid grid = new Grid(10, 10);
        grid.renderGrid(grid);
    }
}
