package kr.kosc.brd.board;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sonbyeonghwa on 2017. 7. 19..
 */
@Entity
@Data
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String title;
    private String memo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date wrote;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    private int hit;
    private int deleteFlag;

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", memo='" + memo + '\'' +
                ", wrote=" + wrote +
                ", updated=" + updated +
                ", hit=" + hit +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
