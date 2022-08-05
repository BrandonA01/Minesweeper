import java.io.IOException;
import java.util.Random;

public class Board {
    private Space[][] s = new Space[Game.Y][Game.X];        //Y == Row  X == Column

    public Board() {
        int rem = Game.BOMBS;
        Random Ran = new Random();
        double random = Ran.nextDouble(100);
        double prob = (double) Game.BOMBS / (Game.Y * Game.X);
        try{
            for(int i = 0; i < Game.Y; i++){        //This is rows first
                for(int h = 0; h < Game.X; i++){        //This is columns second
                    if(random < prob && rem > 0){       //Adding a bomb
                        s[i][h] = new Space(true);
                        rem--;
                    }
                    else{
                        s[i][h] = new Space(false);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        calcNearbyBombs();
    }

    public void calcNearbyBombs(){
        for(int i = 0; i < Game.Y; i++){
            for(int h = 0; h < Game.X; i++) {
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
                    if(h<Game.X-1 && h<Game.Y-1 && s[i+1][h+1].isBomb()){
                        count++;
                    }
                    //South
                    if(h<Game.Y-1 && s[i+1][h].isBomb()){
                        count++;
                    }
                    //South West
                    if(h<Game.Y-1 && i>0 && s[i+1][h-1].isBomb()){
                        count++;
                    }
                    //West
                    if(h>0 && s[i+1][h].isBomb()){
                        count++;
                    }
                    //North West
                    if(h>0 && i>0 && s[i-1][h-1].isBomb()){
                        count++;
                    }
                    s[i][h].setNearby(count);
                }
            }
        }
    }
    public Space[][] getSpaces(){
        return s;
    }
}