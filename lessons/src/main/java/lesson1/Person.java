package lesson1;

import lesson1.Eatable;
import lesson1.Workable;

public class Person implements Workable, Eatable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("lesson1.Person works");
    }

    @Override
    public void eat() {
        System.out.println("lesson1.Person eats");
    }

    @Override
    public void rest() {
        System.out.println("lesson1.Person rest");
    }
}
