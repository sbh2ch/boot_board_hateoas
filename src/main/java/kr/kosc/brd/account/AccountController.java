package kr.kosc.brd.account;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kiost on 2017-07-20.
 */
@RestController
public class AccountController {

    @GetMapping("/hello")
    public ResponseEntity hello() {

        return new ResponseEntity<>("hello ws", HttpStatus.OK);
    }
}