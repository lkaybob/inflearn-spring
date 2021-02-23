package me.lkaybob.springjpademo.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // @Query(nativeQuery = true, value = "select * from account where username = {0}")
    // 쿼리 어노테이션을 이렇게 쓸 수 있는 정도만 알아두자 (실제로는 이렇게 할 필요가... 없음...)
    Account findByUsername(String username);
}
