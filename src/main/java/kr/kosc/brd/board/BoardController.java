package kr.kosc.brd.board;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sonbyeonghwa on 2017. 7. 19..
 */
@RestController
@Slf4j
public class BoardController {
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/test")
    public ResponseEntity test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

}
