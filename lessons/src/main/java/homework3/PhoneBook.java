package homework3;

import java.util.*;

public class PhoneBook {
    private final Map<String ,List<String>> phoneBook = new HashMap<>();

    public void add(String name, String number) {
        List<String> numbers = phoneBook.getOrDefault(name,new ArrayList<>());
        numbers.add(number);
        phoneBook.put(name,numbers);
    }

    List<String> get(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }





}
