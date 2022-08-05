import java.awt.*;
import java.util.ArrayList;

public class NextSpaces {
    private Space n;
    private Space ne;
    private Space e;
    private Space se;
    private Space s;
    private Space sw;
    private Space w;
    private Space nw;
    ArrayList<Space> spaces = new ArrayList<Space>();

    public Space checkSquare(int Y, int X, Space[][] board){
        boolean bool1 = Y < board.length && Y >= 0;
        boolean bool2 = X >= 0 && X < board.length;
        return (bool1 && bool2 ? board[Y][X] : null);
    }

    public ArrayList<Space> emptySpaces(ArrayList<Space> space, Space[][] board, ArrayList<Space> grid) {

        for (int i = 0; i < space.size(); i++) {
            Space cell = space.get(i);
            if (cell != null) {
                if (!cell.isCleared() && cell.nearby == 0) {
                    board[cell.getY()][cell.getX()].setCleared(true);
                    emptySpaces(set(cell.getY(), cell.getX(), board), board, grid);
                } else if (!cell.isCleared() && cell.nearby > 0) {
                    board[cell.getY()][cell.getX()].setCleared(true);
                }
            }
        }
        grid.clear();
        for (int i = 0; i < board.length; i++) {        //This is rows first
            for (int h = 0; h < board.length; h++) {        //This is columns second
                grid.add(board[i][h]);
            }
        }
        return grid;
    }

    public int nearbyBombs(){
        int bombs = 0;
        for(int i = 0; i < spaces.size(); i++){
            if(spaces.get(i).isBomb()){
                bombs++;
            }
        }
        return bombs;
    }

    public ArrayList<Space> set(int Y, int X, Space[][] board){
        spaces.clear();
        setSpace(1, checkSquare(Y, X-1, board));
        setSpace(2, checkSquare( Y+1, X-1, board));
        setSpace(3, checkSquare( Y+1, X, board));
        setSpace(4, checkSquare(Y+1, X-1, board));
        setSpace(5, checkSquare(Y-1, X, board));
        setSpace(6, checkSquare(Y-1, X-1, board));
        setSpace(7, checkSquare(Y, X-1, board));
        setSpace(8, checkSquare(Y-1, X-1, board));
        spaces.add(n);
        spaces.add(ne);
        spaces.add(e);
        spaces.add(se);
        spaces.add(s);
        spaces.add(sw);
        spaces.add(w);
        spaces.add(nw);
        return spaces;
    }

    public void setSpace(int num,  Space space){
        switch(num){
            case 1:
                n = space;
                break;
            case 2:
                ne = space;
                break;
            case 3:
                e = space;
                break;
            case 4:
                se = space;
                break;
            case 5:
                s = space;
                break;
            case 6:
                sw = space;
                break;
            case 7:
                w = space;
                break;
            case 8:
                nw = space;
                break;
        }
    }
}
