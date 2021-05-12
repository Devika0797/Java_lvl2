package homework1;

public class Treadmill extends Obstacle {

    private String item;
    int length;


    public Treadmill(String item, int length){
        this.item = item;
        this.length = length; // макс длина дорожки
    }

    public int getLength() {
        return length;
    }
    @Override
    public String toString() {
        return item;
    }


}
