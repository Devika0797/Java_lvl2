package homework3;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        Set<String> numbers = phoneBook.getOrDefault(name,new HashSet<>());
        numbers.add(number);
        phoneBook.put(name,numbers);
    }

    public Set<String> get(String name) {
        return Collections.emptySet();
    }





}
