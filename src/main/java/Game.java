public class Game {
    public static final int  WIDTH = 20, HEIGHT = 20, X = 30, Y = 20;
    public static final int GRID = 20;
    public static final int BOMBS = 50;
    private boolean end = false;
    private boolean win = false;
    private int flags;

    public Game(){
        Window w = new Window(WIDTH*X, HEIGHT*Y, GRID, "Minesweeper", this);
    }

    public static void main(String[] args){
        new Game();
    }

}
