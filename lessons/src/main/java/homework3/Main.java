package homework3;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;


public class Main {
    // 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать сколько раз встречается каждое слово.
//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
// номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
// (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

    public static void main(String[] args) {

        System.out.println("Задание 1.");
        List<String> wordsArray = new ArrayList<>(Arrays.asList(
                "white", "black", "yellow", "grey", "blue",
                "pink", "red", "blue", "purple", "orange",
                "brown", "green", "black", "yellow"
        ));
        System.out.println("Массив: " + wordsArray);

        Set<String> uniqueWords = new HashSet<>(wordsArray);
        System.out.println("Уникальные слова: " + uniqueWords);
        // сколько раз встречается слово


        System.out.println("Задание 2.");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "2233234");
        phoneBook.add("Sidorov", "3456778");
        phoneBook.add("Petrov", "2343436");
        phoneBook.add("Ivanov", "9874567");

        System.out.println("Иванов" + phoneBook.get("Ivanov"));
        System.out.println("Сидоров" + phoneBook.get("Sidorov"));
        System.out.println("Петров" + phoneBook.get("Petrov"));

    }
}