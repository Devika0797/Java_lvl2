package lesson2;

public class OuterDemo {

    public static void main(String[] args) {
        Car.Builder builder = new Car.Builder();

        Car car = builder.setColor("Red").setPower(100).build();

        Car greenCar = new Car.Builder().build();

    }
}
