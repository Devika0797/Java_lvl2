public class Person implements Workable, Eatable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("Person works");
    }

    @Override
    public void eat() {
        System.out.println("Person eats");
    }

    @Override
    public void rest() {
        System.out.println("Person rest");
    }
}
