package me.lkaybob.inmemorysample;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;
    private Logger logger = LoggerFactory.getLogger(H2Runner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection = dataSource.getConnection();
        logger.info(connection.getMetaData().getURL());
        logger.info(
                connection.getMetaData().getUserName()
        );

        Statement statement = connection.createStatement();
        String sql = "create table user(id integer not null, name varchar(255), primary key (id));";
        statement.executeUpdate(sql);

        connection.close();

    }
}
