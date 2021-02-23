package me.lkaybob.springjpademo.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest // Repository와 관련된 Bean들만 등록하도록 하는 슬라이싱 테스트. 인메모리 데이터베이스가 반드시 필요
class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    private Logger logger = LoggerFactory.getLogger(AccountRepositoryTest.class);
    @Test
    public void di() {
        // 아무것도 작성 안하고 실행해도 주입이 잘 되는지 확인할 수 있음
        Connection connection = null;
        try {
            // 테스트를 돌릴 때는 인메모리 데이터베이스를 사용하는 것이 좋음
            // 실제 DB를 사용한다면? 느림. 그리고 테스트 DB가 따로 필요함
            connection = dataSource.getConnection();
            logger.info(connection.getMetaData().getURL());
            logger.info(connection.getMetaData().getUserName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void saveTest() {
        Account account = new Account();
        account.setUsername("kaybob");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertThat(newAccount).isNotNull();

        Account existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertThat(existingAccount).isNotNull();

        Optional<Account> optionalExistingAccount = Optional.ofNullable(accountRepository.findByUsername(newAccount.getUsername()));
        assertThat(optionalExistingAccount).isNotEmpty();

        Account notExistingAccount = accountRepository.findByUsername("hello");
        assertThat(notExistingAccount).isNull();

        Optional<Account> optionalNotExistingAccount = Optional.ofNullable(accountRepository.findByUsername("hello"));
        assertThat(optionalNotExistingAccount).isEmpty();

    }
}