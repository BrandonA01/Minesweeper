import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {
    private Space[][] s = new Space[Game.Y][Game.X];        //Y == Row  X == Column
    private ArrayList<Space> grid = new ArrayList<Space>();

    public Board(GridLayout layout) {
        super(layout);
        int rem = Game.BOMBS;
        double prob = (double) Game.BOMBS / (Game.Y * Game.X);
        try{
            for(int i = 0; i < Game.Y; i++){        //This is rows first
                for(int h = 0; h < Game.X; h++){        //This is columns second
                    if(Math.random() < prob && rem > 0){       //Adding a bomb
                        grid.add(s[i][h] = new Space(true));
                        rem--;
                    }
                    else{
                        grid.add(s[i][h] = new Space(false));
                    }
                }
            }
            calcNearbyBombs();
            addCells();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addCells(){
        for(int i = 0; i < grid.size(); i++){
            if(grid.get(i).nearby < 0){
                add(grid.get(i)).setBackground(Color.BLACK);
            }
            else if(grid.get(i).nearby == 1){
                add(grid.get(i)).setBackground(Color.yellow);
            }else if(grid.get(i).nearby == 2){
                add(grid.get(i)).setBackground(Color.orange);
            }else if(grid.get(i).nearby > 2){
                add(grid.get(i)).setBackground(Color.RED);
            }
            else{
                add(grid.get(i));
            }

        }
    }

    public void calcNearbyBombs(){
        String str = "";
        for(int i = 0; i < Game.Y; i++){
            str = "";
            for(int h = 0; h < Game.X; h++) {
                if(!s[i][h].isBomb()){
                    int count = 0;
                    //North
                    if(i>0 && s[i-1][h].isBomb()){
                        count++;
                    }
                    //North East
                    if(h<Game.X-1 && i>0 && s[i-1][h+1].isBomb()){
                        count++;
                    }
                    //East
                    if(h<Game.X-1 && s[i][h+1].isBomb()){
                        count++;
                    }
                    //South East
                    if(h<Game.X-1 && i<Game.Y-1 && s[i+1][h+1].isBomb()){
                        count++;
                    }
                    //South
                    if(i<Game.Y-1 && s[i+1][h].isBomb()){
                        count++;
                    }
                    //South West
                    if(i<Game.Y-1 && h>0 && s[i+1][h-1].isBomb()){
                        count++;
                    }
                    //West
                    if(h>0 && s[i][h-1].isBomb()){
                        count++;
                    }
                    //North West
                    if(h>0 && i>0 && s[i-1][h-1].isBomb()){
                        count++;
                    }
                    s[i][h].setNearby(count);
                }
                else{
                    s[i][h].setNearby(-1);
                }
                if(s[i][h].nearby == -1){
                    str+="x|";
                }
                else{
                    str += s[i][h].nearby+"|";
                }
            }
            System.out.println(str);
        }
    }
    public Space[][] getSpaces(){
        return s;
    }
}