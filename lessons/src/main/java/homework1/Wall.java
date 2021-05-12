package homework1;

public class Wall extends Obstacle{

    private String item;
    int height;

    public Wall(String item, int height){
        this.item = item;
        this.height = height;//  макс высота стены
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return item;
    }



}
