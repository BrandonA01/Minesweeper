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
    ArrayList<Space> spaces;

    public NextSpaces(int Y, int X, Space[][] space){
        setSpace(1, Y, X-1, space);
        setSpace(2, Y+1, X-1, space);
        setSpace(3, Y+1, X, space);
        setSpace(4, Y+1, X-1, space);
        setSpace(5, Y-1, X, space);
        setSpace(6, Y-1, X-1, space);
        setSpace(7, Y, X-1, space);
        setSpace(8, Y-1, X-1, space);
        spaces.add(n);
        spaces.add(ne);
        spaces.add(e);
        spaces.add(se);
        spaces.add(s);
        spaces.add(sw);
        spaces.add(w);
        spaces.add(nw);
    }

    public Space checkSquare(int Y, int X, Space[][] space){
        boolean bool1 = Y < space.length && Y >= 0;
        boolean bool2 = X >= 0 && X < space.length;
        return (bool1 && bool2 ? space[Y][X] : null);
    }

    public void emptySpaces(){
        for(int i = 0; i < spaces.size(); i++){
            Space space = spaces.get(i);
            if(space != null && space.spaces == null){

            }
        }
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

    public void setSpace(int num, int Y, int X, Space[][] space){
        switch(num){
            case 1:
                n = space[Y][X];
                break;
            case 2:
                ne = space[Y][X];
                break;
            case 3:
                e = space[Y][X];
                break;
            case 4:
                se = space[Y][X];
                break;
            case 5:
                s = space[Y][X];
                break;
            case 6:
                sw = space[Y][X];
                break;
            case 7:
                w = space[Y][X];
                break;
            case 8:
                nw = space[Y][X];
                break;
        }
    }
}
