package kr.kosc.brd.commons;

import lombok.Data;

import java.util.List;

/**
 * Created by kiost on 2017-07-20.
 */
@Data
public class ErrorResponse {
    private String message;
    private String code;
    private List<FiledError> errors;

    //todo 나중에
    private static class FiledError {
        private String field;
        private String value;
        private String reason;
    }
}
