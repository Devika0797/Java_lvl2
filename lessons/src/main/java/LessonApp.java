public class LessonApp {
    public static void main(String[] args) {

        User user = new AgedUser("name", 15);
        User user2 = user;
        User user3 = new AgedUser("name", 15);
        if (user instanceof AgedUser) {
            AgedUser agedUser = (AgedUser)user;
            agedUser.info();
        }
        System.out.println(user);

        System.out.println(user == user2);
        System.out.println(user.equals(user2));

        //3
        System.out.println(user == user3);
        System.out.println(user.equals(user3));


        String s = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println("-----------");


        AgedUser au = new AgedUser("u1", 18);
        Person person = new Person("p1");


        Workable workable = au;
        Workable workable1 = person;

        Workable[] workables = new Workable[]{workable, workable1};

        for (Workable w : workables) {
            w.work();
            w.rest();
        }

        Eatable eatable = au;
        Eatable eatable1 = person;

    }
}
