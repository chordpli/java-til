import domain.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User kim = new User("1","1234", "김준호", 12);
        User lee = new User("2","1234", "이준호", 14);

        userList.add(kim);
        userList.add(lee);
        User user = new User();

        userList.stream().map(User -> {return User.getName();}).forEach(u -> System.out.println(u));
        userList.stream().map(User::getName).forEach(System.out::println);
        
    }
}
