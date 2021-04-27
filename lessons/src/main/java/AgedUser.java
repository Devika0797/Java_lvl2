import java.util.Objects;

public final class AgedUser extends User implements Workable, Eatable {
    protected final int age;

    public AgedUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public AgedUser(int age){
        this("def", age);
    }

    public int getAge() {
        return age;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AgedUser agedUser = (AgedUser) o;
        return age == agedUser.age && name.equals(agedUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "AgedUser{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println("Work lazy");
    }

    @Override
    public void eat() {
        System.out.println("AgedUser eats a lot");
    }
}
