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
    ArrayList<Space> spaces = new ArrayList<>(8);

    public Space checkSquare(int Y, int X, Space[][] board){
        boolean bool1 = Y < board.length && Y >= 0;
        boolean bool2 = X >= 0 && X < board.length;
        if(bool1 && bool2){
            return board[Y][X];
        }
        else{
            return null;
        }
    }

    public void emptySpaces(ArrayList<Space> space, Space[][] board, ArrayList<Space> grid, int i) {
        Space cell = space.get(i);
        if (cell != null) {
            if (!cell.isCleared() && cell.nearby == 0) {


            } else if (!cell.isCleared() && cell.nearby > 0) {

            }
            else{

            }
        }

    }

    public int nearbyBombs(ArrayList<Space> space){
        int bombs = 0;
        for(int i = 0; i < space.size(); i++){
            if(space.get(i) != null){
                if(space.get(i).isBomb()){
                    bombs++;
                }
            }
        }
        return bombs;
    }

    public ArrayList<Space> set(int Y, int X, Space[][] board){
        spaces.clear();
        setSpace(1, checkSquare(Y-1, X, board));
        setSpace(2, checkSquare(Y-1, X+1, board));
        setSpace(3, checkSquare(Y, X+1, board));
        setSpace(4, checkSquare(Y+1, X+1, board));
        setSpace(5, checkSquare(Y+1, X, board));
        setSpace(6, checkSquare(Y+1, X-1, board));
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
