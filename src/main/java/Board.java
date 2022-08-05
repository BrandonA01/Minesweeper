public class Board {
    private Space[][] s = new Space[Game.Y][Game.X];        //Y == Row  X == Column

    public Board() {
        int rem = Game.BOMBS;
        double prob = (double) Game.BOMBS / (Game.Y * Game.X);
        try{
            for(int i = 0; i < Game.Y; i++){        //This is rows first
                for(int h = 0; h < Game.X; h++){        //This is columns second
                    if(Math.random() < prob && rem > 0){       //Adding a bomb
                        s[i][h] = new Space(true);
                        rem--;
                    }
                    else{
                        s[i][h] = new Space(false);
                    }
                }
            }
            calcNearbyBombs();
        }catch(Exception e){
            e.printStackTrace();
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