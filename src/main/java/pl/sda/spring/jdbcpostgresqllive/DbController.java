package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.spring.otherbeans.Converter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DbController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private Converter converter;

    @PostConstruct
    public void initialize(){
        userRepository.saveAll(userBuilder.getUsers());
    }

    @GetMapping(value = "read2")
    public List<String> readData2(){
        return userDao.read();
    }

    @GetMapping(value = "write2")
    public String writeData2(){
        userDao.save();
        return "";
    }

    @GetMapping(value = "read3")
    public List<User> readData3(){
        List<User> users = new ArrayList<>();
        Iterable<User> iterator = userRepository.findAll();
        iterator.iterator().forEachRemaining(users::add);

        return users;
    }

    @GetMapping(value = "write3")
    public String writeData3(){
       // userRepository.save(new User("Adam","Miauczynski"));
        userRepository.saveAll(userBuilder.getUsers());
        return null;
    }

    @GetMapping(value = "getadam")
    public String getAdam(){
        User user = userRepository.getUserByFirstName("Adam");
        return user.getFirstName() + " " + user.getLastName();
    }

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
        String sqlQuery = "INSERT INTO public.\"user\"(\n" +
                "\tfirst_name, id, last_name)\n" +
                "\tVALUES ('Fiodor',2, 'Dostojewski');";
        jdbcTemplate.update(sqlQuery);
        return "from write";
    }
}
