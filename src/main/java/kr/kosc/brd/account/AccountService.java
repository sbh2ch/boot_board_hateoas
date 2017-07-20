package kr.kosc.brd.account;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by kiost on 2017-07-20.
 */
@Service
@Transactional // 모든 public 메소드는 transactional 어노테이션이 붙게된다
public class AccountService {
    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create create) {
        Account account = new Account();
        account.setUsername(create.getUsername());
        account.setPassword(create.getPassword());
        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);

        return repository.save(account);
    }
}
