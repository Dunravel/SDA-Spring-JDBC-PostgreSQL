package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public void initUsers(){
        userRepository.save(new User("Adam","Miauczynski"));
        userRepository.save(new User("Fiodor","Dostoyewski"));
        userRepository.save(new User("Gal","Anonim"));
    }
}
