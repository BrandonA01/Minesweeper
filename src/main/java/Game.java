public class Game {
    public static final int  WIDTH = 20, HEIGHT = 20;   //Width and height of each cell
    public static final int X = 30, Y = 20;   //amount of cells I want in the frame
    public static final int GRID = 20;
    public static final int BOMBS = 50;
    private boolean end = false;
    private boolean win = false;
    private int flags;

    public Game(){
        Window w = new Window(WIDTH*X, HEIGHT*Y, GRID, "Minesweeper", this);
        Board b = new Board();
    }

    public static void main(String[] args){
        new Game();
    }

}
