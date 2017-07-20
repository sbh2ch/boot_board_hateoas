package kr.kosc.brd.account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by kiost on 2017-07-20.
 */
public class AccountTest {
    public void getterSetter() {
        Account account = new Account();
        account.setUsername("bh");
        account.setPassword("11");
        assertThat(account.getUsername(), is("bh"));
    }
}