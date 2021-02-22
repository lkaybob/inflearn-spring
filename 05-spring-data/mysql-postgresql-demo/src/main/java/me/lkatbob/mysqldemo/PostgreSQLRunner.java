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

@Component
public class PostgreSQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(PostgreSQLRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Connection connection = dataSource.getConnection();
        logger.info(connection.getMetaData().getURL());
        logger.info(connection.getMetaData().getUserName());

        Statement statement = connection.createStatement();
        String sql = "create table account(id integer not null, name varchar(255), primary key (id));";
        statement.executeUpdate(sql);

        jdbcTemplate.execute("insert into account values(1, 'kaybob');");

        connection.close();
    }
}
