package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends JdbcDaoSupport {
//    private int id;
//    private static int lastId;
    private String firstName;
    private String lastName;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        setDataSource(dataSource);
    }

    public void save(){
        String sqlQuery = "INSERT INTO public.\"user\"(\n" +
                "\tfirst_name, id, last_name)\n" +
                "\tVALUES ('Gal',3, 'Anonim');";
        getJdbcTemplate().update(sqlQuery );
    }

    public List<String> read(){
        String sqlQuery = "SELECT * FROM public.user";
        List<Map<String, Object>> users = getJdbcTemplate().queryForList(sqlQuery);

        List<String> results = new ArrayList<>();

        for(Map<String,Object> user:users){
            String userStr = user.get("first_name") + " " + user.get("last_name");
            results.add(userStr);
        }
        return results;

    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId() {
//        lastId += 1;
//        this.id = lastId;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
