package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
