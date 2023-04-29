import java.util.*;


public class JAVA_HW_05 {

    public static void main(String[] args) {

        System.out.println("Введите номер задачи (1 - 2): ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number){
        case 1:
            task1();
            break;
        case 2:
            task2();
            break;
        }        
    }
    
    static void task1() {
        /*
         * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
         */
        boolean label = true;
        Scanner scanner = new Scanner(System.in);
        while(label){
            System.out.println("Что Вы хотите сделать: 1 - добавить пользователя, 2 - найти пользователя, 3 - выйти?");
            int number = scanner.nextInt();
            switch(number){
                case 1:
                    System.out.println("Введите имя: ");
                    String name = scanner.next();
                    System.out.println("Введите номер телефона: ");
                    String phone = scanner.next();
                    PhBook.AddUser(name, phone);
                break;
                case 2:
                    System.out.print("Введите имя: ");
                    String name1 = scanner.next();
                    PhBook.FindUser(name1);
                break;
                case 3:
                    label = false;
                break;
            }
        }        
    }

    static void task2() {
        /*
        Пусть дан список сотрудников:
        Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,
        Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
        Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
         */
        String line = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,\n" +
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,\n" +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        line = line.replace("\n", " ");
        line = line.replace(",", "");
        String[] words = line.split(" ");
        List<String> newWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if(i % 2 == 0){
                newWords.add(words[i]);
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (String n: newWords) {
            if(map.containsKey(n)){
                int counter = map.get(n);
                map.put(n, counter + 1);

            } else {
                map.put(n, 1);
            }
        }
        Map<Integer, List<String>> map2 = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> temp : map.entrySet()) {
            if(map2.containsKey(temp.getValue())) {
                List<String> list = new ArrayList<>();
                list.add(map2.get(temp.getValue()).toString());
                list.add(temp.getKey());
                map2.put(temp.getValue(), list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(temp.getKey());
                map2.put(temp.getValue(), list);
            }
        }
        System.out.println(map2);
    }
}