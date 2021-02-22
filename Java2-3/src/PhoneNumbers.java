import java.util.HashMap;
import java.util.Map;

public class PhoneNumbers {
    private Map<String, String> list = new HashMap();

    public void add (String surname, String phoneNum) {
        if (list.containsKey(surname)) list.put(surname, list.get(surname) + " " + phoneNum);
        else list.put(surname, phoneNum);
    }

    public String get (String surname) {
        if (list.containsKey(surname)) return list.get(surname);
        return "No such person";
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
