import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel {
    private Space[][] s = new Space[Game.Y][Game.X];        //Y == Row  X == Column
    private ArrayList<Space> grid = new ArrayList<Space>();
    private NextSpaces nextSpaces = new NextSpaces(s);

    public Board(GridLayout layout) {
        super(layout);
        int rem = Game.BOMBS;
        double prob = (double) rem / (Game.Y * Game.X); // Amount of bombs left / Number of cells
        try {
            for (int i = 0; i < Game.Y; i++) {        //This is rows first
                for (int h = 0; h < Game.X; h++) {        //This is columns second
                    if (Math.random() < prob && rem > 0) {       //Adding a bomb
                        grid.add(s[i][h] = new Space(true, nextSpaces, i, h));
                        rem--;
                    } else {
                        grid.add(s[i][h] = new Space(false, nextSpaces, i, h));
                    }
                }
            }
            for (int i = 0; i < grid.size(); i++) {
                if(grid.get(i).isBomb()){
                    grid.get(i).setText("x");
                    grid.get(i).setNearby(-1);
                    grid.get(i).setBackground(Color.blue);
                }
                else{
                    ArrayList<Space> space = nextSpaces.set(grid.get(i).getCoords()[0], grid.get(i).getCoords()[1]);
                    grid.get(i).setNearby(nextSpaces.nearbyBombs(space));
                    grid.get(i).setBackground(Color.GRAY);
                    grid.get(i).setText(String.valueOf(grid.get(i).nearby));
                }

                addCells(nextSpaces, grid);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addCells(NextSpaces nextSpaces, ArrayList<Space> grid){
        for(int i = 0; i < grid.size(); i++){
            add(grid.get(i));
        }
    }

    public Space[][] getSpaces(){
        return s;
    }

}