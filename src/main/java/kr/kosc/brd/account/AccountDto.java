package kr.kosc.brd.account;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by kiost on 2017-07-20.
 */
public class AccountDto {

    @Data
    public static class Create {
        @NotBlank
        @Size(min = 5)
        private String username;

        @NotBlank //트레일링 whitespace를 함.
        @Size(min = 5)
        private String password;

    }

    @Data
    public static class Response {
        private Long id;
        private String username;
        private Date joined;
        private Date updated;
    }
}
