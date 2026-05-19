package HWK9;

import java.io.Serializable;

public class ScoreRecord implements Serializable {
    int id;
    String name;
    float score;
    ScoreRecord(){
        id = 0; name = "Unknown Student"; score = -1;
    }
    ScoreRecord(int id, String name, float score){
        this.id = id; this.name = name; this.score = score;
    }
    public String toString(){
        return String.format("(%d, %s, %.2f)", id, name, score);
    }
}
