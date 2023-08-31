package com.example.springbootjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest2 {

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
    public void countTest(){

        assertTrue(boardReop.countAllByWriter("writer1") == 20);
    }
    @Test
    public void findTest(){
        List<Board> list = boardReop.findByWriter("writer1");
        assertTrue(list.size()==20);
        list.forEach(System.out::println);
    }
    @Test
    public void deleteTest(){
        assertTrue(boardReop.deleteByWriter("writer1")==20);
        List<Board> list = boardReop.findByWriter("writer1");
        assertTrue(list.size()==0);
    }
}