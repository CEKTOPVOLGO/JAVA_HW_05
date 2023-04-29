import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhBook {
    static private  Map<String, List<String>> map = new HashMap<>();

    static void AddUser(String user, String number) {

        if (map.containsKey(user)){
            List<String> list = new ArrayList<>();
            list = map.get(user);
            list.add(number);
            map.put(user, list);
        } else{
            List<String> list = new ArrayList<>();
            list.add(number);
            map.put(user, list);
        }
        System.out.println("OK!");

    }

    static void FindUser(String user) {
        if(map.containsKey(user)){
            System.out.println("Имя: " + user + " телефон: " + map.get(user));
        } else {
            System.out.println("Такого пользователя не существует");
        }
    }
}

