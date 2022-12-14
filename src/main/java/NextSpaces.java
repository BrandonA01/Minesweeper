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
    Space[][] board;
    ArrayList<Space> queue = new ArrayList<>();

    public NextSpaces(Space[][] board) {
        this.board = board;
    }

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

    public void emptySpaces(ArrayList<Space> space) {
        for (int i = 0; i < space.size(); i++){
            if(space.get(i) != null){
                if (!space.get(i).isCleared() && space.get(i).nearby == 0) {
                    space.get(i).setCleared(true);
                    space.get(i).setBackground(Color.white);
                    queue.add(space.get(i));
                } else if (!space.get(i).isCleared() && space.get(i).nearby > 0) {
                    space.get(i).setCleared(true);
                    space.get(i).setBackground(Color.white);
                    space.get(i).setText(String.valueOf(space.get(i).nearby));
                }
            }
        }
        for(int i = 0; i < queue.size(); i++){
            if (queue.size()==1){
                Space s = queue.get(i);
                queue.remove(i);
                emptySpaces(set(s.coords[0], s.coords[1]));
            }
            else{
                queue.remove(i);
                emptySpaces(set(queue.get(i).coords[0], queue.get(i).coords[1]));
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

    public ArrayList<Space> set(int Y, int X){
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
