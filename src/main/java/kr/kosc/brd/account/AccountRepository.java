package kr.kosc.brd.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kiost on 2017-07-20.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}