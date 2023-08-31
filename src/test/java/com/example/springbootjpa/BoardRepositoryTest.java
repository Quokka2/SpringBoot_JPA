package com.example.springbootjpa;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardReop;

    @Test
    public void deleteTest(){
        boardReop.deleteById(1L);

        Board board = boardReop.findById(1L).orElse(null);
        assertTrue(board==null);
    }

    @Test
    @Order(3)
    public void updateTest(){
        Board board = boardReop.findById(1L).orElse(null);
        assertTrue(board!=null);

        board.setTitle("modified Title");
        boardReop.save(board);

        Board board2 = boardReop.findById(1L).orElse(new Board());


        assertTrue(board.getTitle().equals(board2.getTitle()));
    }


    @Test
    @Order(2)
    public void selectTest(){
        Board board = boardReop.findById(1L).orElse(null);
        assertTrue(board!=null);
    }
    @Test
    @Order(1)
    public void insertTest(){
        Board board = new Board();
        board.setBno(1L);
        board.setTitle("Test Title");
        board.setContent("This is Test");
        board.setWriter("aaa");
        board.setViewCnt(0L);
        board.setInDate(new Date());
        board.setUpDate(new Date());
        boardReop.save(board);
    }
}