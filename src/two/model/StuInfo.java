package two.model;

import java.io.Serializable;

public class StuInfo implements Serializable{
    private String name;
    private String id;
    private double score;

    public StuInfo(String name, String id){
        this.name = name;
        this.id = id;
    }

    public StuInfo(String name, String id, Double score){
        this(name, id);
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "[ 姓名: " + this.name + "  学号: " + this.id + "  成绩: " + this.score + " ]\n";
    }
}
