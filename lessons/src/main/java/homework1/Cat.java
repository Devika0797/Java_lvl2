package homework1;

public class Cat implements RunableJumpable {

    private String name;
    int maxLength;
    int maxHeight;

    public Cat(String name, int maxLength, int maxHeight){
        this.name = name;
        this.maxLength = maxLength; // макс длина бега
        this.maxHeight = maxHeight; // макс высота прыжка
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean run(Obstacle obstacle) {
       // System.out.println("Cat run");
        return maxLength >= ((Treadmill) obstacle).getLength();

    }

    @Override
    public boolean jump(Obstacle obstacle) {
        //System.out.println("Cat jump");
        return maxHeight >= ((Wall) obstacle).getHeight();

    }

}
