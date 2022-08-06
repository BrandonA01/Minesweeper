import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Space extends JButton {
    boolean bomb;
    boolean flagged;
    boolean cleared;
    int nearby;
    private NextSpaces nextSpaces;

    public int[] getCoords() {
        return coords;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    int[] coords = new int[2];

    public Space(boolean bomb, NextSpaces n, int Y, int X){
        coords[0] = Y;
        coords[1] = X;
        this.nextSpaces = n;
        this.bomb = bomb;
        flagged = false;
        cleared = false;
        nearby = 0;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!cleared){
                    if(nearby == 0){
                        setBackground(Color.white);
                        setEnabled(false);
                        cleared=true;
                    }
                    else if (nearby>0) {
                        setBackground(Color.white);
                        setEnabled(false);
                        cleared=true;
                    }
                    else if (bomb){
                        System.out.println("You Lose!");
                        cleared=true;
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void setCleared(boolean cleared) {
        this.cleared = cleared;
    }

    public void setNearby(int nearby) {
        this.nearby = nearby;
    }

    public boolean isBomb() {
        return bomb;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean isCleared() {
        return cleared;
    }

    public int getNearby() {
        return nearby;
    }
}