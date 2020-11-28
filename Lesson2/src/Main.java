
class Main{

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). \
// Посчитать сколько раз встречается каждое слово.

//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
// несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

//Желательно как можно меньше добавлять своего, чего нет в задании
// (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
// делать взаимодействие с пользователем через консоль и т.д.).
// Консоль желательно не использовать (в том числе Scanner),
// тестировать просто из метода main() прописывая add() и get().

    public static void main(String[] args) {
        String[][] good = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] bad1 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] bad2 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {},
                {"1", "2", "3", "4"}
        };

        String[][] bad3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"Z", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            System.out.println("Сумма элементов массива = " + transformArrayToInt(good));
            //System.out.println("Сумма элементов массива = " + transformArrayToInt(bad1));
            //System.out.println("Сумма элементов массива = " + transformArrayToInt(bad2));
            System.out.println("Сумма элементов массива = " + transformArrayToInt(bad3));

        } catch (MySizeArrayException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int transformArrayToInt(String[][] array) throws MySizeArrayException, MyArrayDataException {

        if (array.length != 4) throw new MySizeArrayException("массив имеет неверную размерность. Нужен 4х4");

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) throw new MySizeArrayException("неверный размер внутреннего массива с индексом: " + i);
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("невозможно преобразовать ячейку %d массива %d со значением %s", j, i, array[i][j]), e);
                }
            }
        }
        return sum;
    }
}
