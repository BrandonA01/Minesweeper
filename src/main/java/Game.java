public class Game {
    public static final int  WIDTH = 20, HEIGHT = 20;   //Width and height of each cell
    public static final int X = 20, Y = 20;   //amount of cells I want in the frame
    public static final int BOMBS = 50;
    private boolean end = false;
    private boolean win = false;
    private int flags;

    public Game(){
        Window w = new Window(WIDTH*X, HEIGHT*Y, X, Y, "Minesweeper", this);
    }

    public static void main(String[] args){
        new Game();
    }

}
