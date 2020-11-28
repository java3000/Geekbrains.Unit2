import java.util.*;

public class Main {

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать сколько раз встречается каждое слово.

//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии. Следует учесть,
// что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

    //Желательно как можно меньше добавлять своего,
// чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
// делать взаимодействие с пользователем через консоль и т.д.).
// Консоль желательно не использовать (в том числе Scanner),
// тестировать просто из метода main() прописывая add() и get().

    public static void main(String[] args) {

        //1
        String[] words = new String[]{
                "Создать", "Найти", "класс", "можно", "Посчитать", "искать", "Найти", "выводиться", "надо", "использовать",
                "меньше", "искать", "встречается", "взаимодействие", "телефонный", "класс", "метода", "слово", "учесть", "искать"
        };

        HashSet<String> distinctWords = new HashSet<>(Arrays.asList(words));
        System.out.println(Arrays.toString(distinctWords.toArray()));

        Map<String, Integer> countedMap = countWords(words);

        for (Map.Entry<String, Integer> entry : countedMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


        //2
        System.out.println();

        PhoneBook book = new PhoneBook();

        book.add("Иванов1", "123");
        book.add("Петров", "234");
        book.add("Иванов2", "123"); //не попадет
        book.add("Сидоров", "567");
        book.add("Сидоров", "678"); //однофамилец
        book.add("Сидоров", "789"); //однофамилец

        List<String> resultForOne = book.get("Петров");
        List<String> resultForNone = book.get("Иванов2");
        List<String> resultForMany = book.get("Сидоров");

        for (String s : resultForOne) System.out.println("Петров: " + s);
        for (String s : resultForNone) System.out.println("Иванов2: " + s);
        for (String s : resultForMany) System.out.println("Сидоров: " + s);
    }

    private static Map<String, Integer> countWords(String[] array) {
        Map<String, Integer> result = new HashMap<>();
        int counter;

        for (String s : array) {
            counter = 0;
            for (String s1 : array) {
                if (s.equals(s1)) counter++;
            }
            result.put(s, counter);
        }
        return result;
    }
}
