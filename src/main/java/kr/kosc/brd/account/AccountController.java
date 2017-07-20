package kr.kosc.brd.account;

import kr.kosc.brd.commons.ErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
    private ModelMapper modelMapper;

    @PostMapping("/accounts")
    public ResponseEntity createAccount(@RequestBody @Valid AccountDto.Create create, BindingResult result) {
        //@RequestBody를 쓰면 등록되어있는 메세지컨버터가 Request 본문에 들어있는 Json데이터를 객체로 바인딩해준다.
        if (result.hasErrors()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("잘못된 요청입니다.");
            errorResponse.setCode("bad.request");
            //todo BindingResult 안에 들어있는 에러 정보 활용이 필요

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        Account account = service.createAccount(create);
        /*
        * 1. 리턴 타입으로 확인
        * 2. 인자값(파라미터) 이용하기
        *   method(param, result);
        *   if(result.hasError()){ ,,, }
        * 3. Exception 처리
        *
        * */
        return new ResponseEntity<>(modelMapper.map(account, AccountDto.Response.class), HttpStatus.CREATED);
    }

    @ExceptionHandler(UserDuplicatedException.class)
    public ResponseEntity handleUserDuplicatedException(UserDuplicatedException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("[" + e.getUsername() + "] 중복 이메일 입니다.");
        errorResponse.setCode("duplicated.username.exception");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}