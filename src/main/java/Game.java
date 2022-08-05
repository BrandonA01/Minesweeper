public class Game {
    public static final int  WIDTH = 700, HEIGHT = 700;
    public static final int GRID = 20;
    public static final int BOMBS = 50;

    public Game(){
        Window w = new Window(WIDTH, HEIGHT, GRID, "Minesweeper", this);
    }

    public static void main(String[] args){
        new Game();
    }

}
