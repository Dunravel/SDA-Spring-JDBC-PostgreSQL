package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByFirstName(String name);
    List<User> getUsersByFirstNameContains(String text);
    User getUserByLastNameAndAndFirstName(String lastName, String firstName);
}
