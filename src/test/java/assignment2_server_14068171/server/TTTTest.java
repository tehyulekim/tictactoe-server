package assignment2_server_14068171.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class TTTTest {

    TTT ttt = new TTT();


    @Before
    public void before(){}

    @After
    public void after(){}


    @Test
    public void test(){    }


    @Test
    public void test1(){
        ttt.moveMark(1,1,'1');
        ttt.moveMark(1,2,'2');
        ttt.moveMark(1,3,'3');
        ttt.moveMark(2,1,'4');
        ttt.moveMark(2,2,'5');
        ttt.moveMark(2,3,'6');
        ttt.moveMark(3,1,'7');
        ttt.moveMark(3,2,'8');
        ttt.moveMark(3,3,'9');
        System.out.println(ttt.boardToString());
    }


    @Test
    public void test2(){
        ttt.moveX(1,2);
        ttt.moveX(2,2);
        ttt.moveX(3,3);

        System.out.println(Arrays.deepToString(ttt.getBoard()));

        System.out.println(ttt.boardToString());

    }


    @Test
    public void test3(){


        ttt.movePlayer(1, 2);
        ttt.movePlayer(2, 1);
        ttt.movePlayer(2, 3);
        ttt.movePlayer(3, 2);

        ttt.movePlayer(1, 1);
        ttt.movePlayer(3, 3);
        ttt.movePlayer(1, 3);
        ttt.movePlayer(3, 1);
        ttt.movePlayer(2, 2);

        ttt.printBoard();


    }

    @Test
    public void test4(){

    }

    @Test
    public void test5(){

    }

    @Test
    public void test6(){

    }




}
