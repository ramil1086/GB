import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Один", "Три", "Три", "Восемь", "Один", "Один", "Один", "Шесть", "Восемь", "Девять", "Десять", "Один", "Семь"};
        Map<String, Integer> wordsSet = new HashMap();
        for (String list : words) {
            if (wordsSet.containsKey(list)) { wordsSet.put(list, wordsSet.get(list)+1); }
            else wordsSet.put(list, 1);
        }
        System.out.println(new HashSet(Arrays.asList(words)));
        System.out.println(wordsSet);

        PhoneNumbers phoneNumbers = new PhoneNumbers();
        phoneNumbers.add("Иванов", "911-111-11-11");
        phoneNumbers.add("Петров", "922-222-22-22");
        phoneNumbers.add("Сидоров", "933-333-33-33");
        phoneNumbers.add("Иванов", "944-444-44-44");
        phoneNumbers.add("Сидоров", "955-555-55-55");
        System.out.println(phoneNumbers);

        System.out.println(phoneNumbers.get("Иванов"));
        System.out.println(phoneNumbers.get("Тестов"));

    }
}
