package homework1;

public class Human implements RunableJumpable {

    private String name;
    int maxLength;
    int maxHeight;

        public Human(String name, int maxLength, int maxHeight){
            this.name = name;
            this.maxLength = maxLength; // макс длина бега
            this.maxHeight = maxHeight; // макс высота прыжка
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public void run() {
            System.out.println("Human run");
        }

        @Override
        public int getMaxLength() {
            return maxLength;
        }

        @Override
        public void jump() {
            System.out.println("Human jump");
        }

        @Override
        public int getMaxHeight() {
            return maxHeight;
        }



}
