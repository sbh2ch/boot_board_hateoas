package kr.kosc.brd.account;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Account createAccount(AccountDto.Create dto) {
        Account account = modelMapper.map(dto, Account.class);
        //todo 유효한 username인지 판단
        if (repository.findByUsername(dto.getUsername()) != null) {
            throw new UserDuplicatedException(dto.getUsername());
        }

        Date now = new Date();
        account.setJoined(now);
        account.setUpdated(now);

        return repository.save(account);
    }
}
