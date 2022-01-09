import java.io.Serializable;

class Marks implements Serializable {
    private int markInProg;

    public Marks(){};

    public Marks(int mark){
        this.markInProg = mark;
    }

    public int getMarkInProg() {return markInProg;}

    public void setMarkInProg(int markInProg) {this.markInProg = markInProg;}
}