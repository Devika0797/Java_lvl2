package homework3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
        private final HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

        public void add(String name, String number) {
            HashSet<String> numbers = phoneBook.getOrDefault(name,new HashSet<>());
            numbers.add(number);
            phoneBook.put(name,numbers);
        }

        public HashSet<String> get(String name) {
            return phoneBook.get(name);
        }


}
