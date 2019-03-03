package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "read")
    public String readData(){
        String sqlQuery = "SELECT * FROM public.user";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sqlQuery);

        List<String> results = new ArrayList<>();

        for(Map<String,Object> user:users){
            String userStr = user.get("first_name") + " " + user.get("last_name");
            results.add(userStr);
        }
        return "users amount: " + users.size() + "\n " + results;
    }

    @GetMapping(value = "write")
    public String writeData(String text){
        return "from write";
    }
}
