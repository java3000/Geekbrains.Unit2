public class Main {

    //1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
    // при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    //2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
    // Если в каком-то элементе массива преобразование не удалось (например,
    // в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException,
    // с детализацией в какой именно ячейке лежат неверные данные.
    //3. В методе main() вызвать полученный метод, обработать возможные исключения
    // MySizeArrayException и MyArrayDataException, и вывести результат расчета.

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
