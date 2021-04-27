public class Worker {

    private final AgedUser agedUser;
    //2
    private final String position;

    public Worker(String name, int age, String position) {
        this.agedUser = new AgedUser(name, age);
        this.position = position;
    }

    public String getName() {
        return agedUser.getName();
    }
}
