package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBuilder {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("Adam","Miauczynski"));
        users.add(new User("Fiodor","Dostoyewski"));
        users.add(new User("Gal","Anonim"));
        return users;
    }
}
