package homework1;

public class Wall implements Obstacable {

    private String item;
    int height;

    public Wall(String item, int height){
        this.item = item;
        this.height = height;//  макс высота стены
    }

    @Override
    public String toString() {
        return item;
    }

    @Override
    public boolean getRun(int maxLength){
        return false;
    }

    @Override
    public boolean getJump(int maxHeight){
        return maxHeight >= height; // высота прыжка >= макс высоты стены
    }
}
