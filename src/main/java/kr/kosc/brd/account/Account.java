package kr.kosc.brd.account;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kiost on 2017-07-20.
 */
@Entity
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

}