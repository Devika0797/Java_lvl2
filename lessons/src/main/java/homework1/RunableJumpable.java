package homework1;

public interface RunableJumpable {
    boolean run(Obstacle obstacle);

    boolean jump(Obstacle obstacle);

    default boolean pass(Obstacle obstacle) {
        if (obstacle instanceof Treadmill) {
            return run(obstacle);
        } else if (obstacle instanceof Wall) {
            return jump(obstacle);
        } else {
            return false;
        }
    }
}
