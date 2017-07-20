package kr.kosc.brd.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by kiost on 2017-07-20.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRepository repository;

    @PostMapping("/accounts")
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create, BindingResult result) {
        //@RequestBody를 쓰면 등록되어있는 메세지컨버터가 Request 본문에 들어있는 Json데이터를 객체로 바인딩해준다.
        if (result.hasErrors()) {
            //todo 에러 응답 본문 추가하기
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account account = service.createAccount(create);

        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
}