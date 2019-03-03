package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("pl.sda.spring.otherbeans")
public class JdbcPostgresqlLiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(JdbcPostgresqlLiveApplication.class, args);
    }

}
