package package1;

/**
 * Created by paulo on 19/04/2016.
 */
public class Clue {
    private int crimeLoc;
    private int roadClue;

    public Clue(int crimeLoc, int roadClue) {
        this.crimeLoc = crimeLoc;
        this.roadClue = roadClue;
    }

    public int getCrimeLoc() {
        return crimeLoc;
    }

    public int getRoadClue() {
        return roadClue;
    }

}
