package lesson2;

public class Car {
// файналы поля объекта
    private final String color;
    private final String vin;
    private final int year;
    private final int power;

    private Car (Builder builder){
        this.color = builder.color;
        this.vin = builder.vin;;
        this.year = builder.year;
        this.power = builder.power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", vin='" + vin + '\'' +
                ", year=" + year +
                ", power=" + power +
                '}';
    }

    public static class Builder{
        private String color;
        private String vin;
        private int year;
        private int power;

        public Builder setColor (String color) {
            this.color = color;
            return this;
        }
        public Builder setVin (String vin) {
            this.vin = vin;
            return this;
        }
        public Builder setYear (int year) {
            this.year = year;
            return this;
        }
        public Builder setPower (int power) {
            this.power = power;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

}

