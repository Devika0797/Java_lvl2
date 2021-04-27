package lesson2;

public enum Month {
    JAN("January", 1),
    FEB("February", 2),
    MAR("March", 3),
    APR("April", 4),
    MAY("May", 5);

    private final String fullName;
    private final int number;

    Month(String fullName, int number) {
        this.fullName = fullName;
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }
    public int getNumber() {
        return number;
    }

    public boolean isSpring() {
        return this == MAR || this == APR || this == MAY;
    }
}
