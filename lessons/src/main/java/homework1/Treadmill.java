package homework1;

public class Treadmill implements Obstacable {

    private String item;
    int length;


    public Treadmill(String item, int length){
        this.item = item;
        this.length = length; // макс длина дорожки
    }

    @Override
    public String toString() {
        return item;
    }

    @Override
    public boolean getRun(int maxLength){
        return maxLength >= length; // длина бега >= макс длины дорожки
    }

    @Override
    public boolean getJump(int maxHeight){
        return false;
    }
}
