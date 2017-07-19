package kr.kosc.brd.board;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sonbyeonghwa on 2017. 7. 19..
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
