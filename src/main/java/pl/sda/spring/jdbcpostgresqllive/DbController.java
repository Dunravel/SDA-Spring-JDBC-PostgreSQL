package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "read")
    public String readData(){
        return "from read";
    }

    @GetMapping(value = "write")
    public String writeData(String text){
        return "from write";
    }
}
