package kr.kosc.brd.account;

/**
 * Created by kiost on 2017-07-20.
 */
public class UserDuplicatedException extends RuntimeException {
    private String username;

    public UserDuplicatedException(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
