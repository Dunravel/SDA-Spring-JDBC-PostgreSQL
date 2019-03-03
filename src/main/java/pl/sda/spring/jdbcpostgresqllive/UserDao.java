package pl.sda.spring.jdbcpostgresqllive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

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
        getJdbcTemplate().update("");
    }

    public void read(){

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
