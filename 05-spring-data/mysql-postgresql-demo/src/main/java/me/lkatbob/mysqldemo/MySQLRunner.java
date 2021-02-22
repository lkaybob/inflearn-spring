package me.lkatbob.mysqldemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

//@Component
public class MySQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate; // Spring JDBC의 핵심은 JdbcTemplate. Transaction에 관한 것은 Spring Framework에 관한 것이라...
    // 자세한 것은 Spring Framework Core쪽 자료/강의를 봐야할 듯

    private Logger logger = LoggerFactory.getLogger(MySQLRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        logger.info(connection.getMetaData().getURL());
        logger.info(connection.getMetaData().getUserName());

        Statement statement = connection.createStatement();
        String sql = "create table user(id integer not null, name varchar(255), primary key (id));";
        statement.executeUpdate(sql);

        jdbcTemplate.execute("insert into user value(1, 'kaybob');");

        connection.close();
    }
}
