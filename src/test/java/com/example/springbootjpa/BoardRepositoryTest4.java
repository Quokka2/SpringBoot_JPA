package com.example.springbootjpa;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest4 {

    @Autowired
    private EntityManager em;
    @Autowired
    private BoardRepository boardReop;

    @BeforeEach
    public void testData(){
        for (int i = 0; i < 100; i++){
            Board board = new Board();
            board.setBno((long)i);
            board.setTitle("title" + i);
            board.setContent("content"+i);
            board.setWriter("writer"+(i % 5));
            board.setViewCnt((long)(Math.random()*100));
            board.setInDate(new Date());
            board.setUpDate(new Date());
            boardReop.save(board);
        }
    }

    @Test
    @DisplayName("querydsl로 쿼리 작성 테스트1 - 간단한 쿼리작성")
    public void querydslTest1(){
        QBoard board = QBoard.board;
        JPAQueryFactory qf = new JPAQueryFactory(em);

        JPAQuery<Board> query = qf.selectFrom(board)
                .where(board.title.eq("title1"));

        List<Board> list = query.fetch();
        list.forEach(System.out::println);
    }
}