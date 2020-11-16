import document.AsiaDocument;
import document.Document;
import document.EuropeDocument;
import document.ToyotaContract;
import ext.ExternalDocumentManager;

//1. Разобраться с имеющимся кодом;
//2. Добавить класс Team, который будет содержать: название команды,
// массив из 4-х участников (т.е. в конструкторе можно сразу всех участников указывать),
// метод для вывода информации о членах команды прошедших дистанцию,
// метод вывода информации обо всех членах команды.
//3. Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий,
// метод который будет просить команду пройти всю полосу;
//То есть в итоге должно быть:
//
//public static void main(String[] args) {
//Course c = new Course(...); // Создаем полосу препятствий
//Team team = new Team(...); // Создаем команду
//c.doIt(team); // Просим команду пройти полосу
//team.showResults(); // Показываем результаты
//}

public class Main {
    public static void main(String[] args) {
        doDemo2();
    }

    static void doDemo2() {
        ExternalDocumentManager manager = new ExternalDocumentManager();
        manager.manage();
    }

    static void doDemo1() {
        Document[] contracts = {
                new AsiaDocument(),
                new EuropeDocument(),
                new EuropeDocument(),
                new AsiaDocument(),
                new AsiaDocument(),
                new ToyotaContract()
        };

        for (Document doc : contracts) {
            doc.doCheck();
        }
    }
}
