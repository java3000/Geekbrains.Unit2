import java.util.*;

class PhoneBook {

    private Map<String, String> entities = new HashMap<>();

    public List<String> get(String family) {

        List<String> keys = new ArrayList<>();

        for (Map.Entry<String, String> e : entities.entrySet())
            if (family.equals(e.getValue())) keys.add(e.getKey());

        return keys;
    }

    public void add(String family, String number) {
        if (!entities.containsKey(number)) entities.put(number, family);
    }

}
