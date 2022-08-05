public class Space {

    boolean bomb;
    boolean flagged;
    boolean cleared;
    int nearby;

    public Space(boolean bomb){
        this.bomb = bomb;
        flagged = false;
        cleared = false;
        nearby = 0;
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