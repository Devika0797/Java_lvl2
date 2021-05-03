package lesson3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HumanApp {
    public static void main(String[] args) {
        Human h1 = new Human("Bob", 12);
        Human h2 = new Human("Kevin", 14);
        Human h3 = new Human("Stewart", 10);

        Map<Human, String> map = new TreeMap<>(new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        map.put(h1, "Moscow");
        map.put(h2, "Berlin");
        map.put(h3, "Saratov");
        System.out.println(map);


    }
}
