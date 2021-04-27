public class User {

    private static int count = 0;
    protected  String name;

    private static final int LENGTH = 200;

    public User(String name) {
        count++;
        this.name = name;
    }

    public User() {
        count++;
    }

    public String getName() {
        return name;
    }

}
