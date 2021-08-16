package assignment2_server_14068171.server;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.*;

// Tic Tac Toe

@Component
@Scope("session")
public class TTT implements Serializable {
    private static int counter = 0;

    public int id;

    // starting index = 1, coordinate system 3x3 array in [4][4], not using 0 index
    // x is axis-right, z is axis-up
    private char[][] board = new char[4][4];
    private boolean gameOver;
    private String winner;

    public TTT() {
        id = ++counter;

        // make empty board. fill with char '_' except index 0
        for (int x = 1; x <= 3; x++) {
            for (int z = 1; z <= 3; z++) {
                board[x][z] = '_';
            }
        }
        gameOver = false;
        winner = "none";
    }

    // if any string is in the parameter, computer starts.
    public TTT(String string) {
        id = ++counter;

        // make empty board. fill with char '_' except index 0
        for (int x = 1; x <= 3; x++) {
            for (int z = 1; z <= 3; z++) {
                board[x][z] = '_';
            }
        }
        gameOver = false;
        winner = "none";
        moveAI();
    }



    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }

    public char[][] getBoard() {
        return board;
    }

    public String boardToString() {
        return Arrays.deepToString(board);
    }

    public void printBoard() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int z = 3; z >= 1; z--) {
            for (int x = 1; x <= 3; x++) {
                stringBuilder.append(this.board[x][z]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }


    public boolean checkCellEmpty(int x, int z) {
        return this.board[x][z] == '_';
    }

    public void moveX(int x, int z) {
        this.board[x][z] = 'X';
    }

    public void moveO(int x, int z) {
        this.board[x][z] = 'O';
    }

    public void moveMark(int x, int z, char mark) {
        this.board[x][z] = mark;
    }


    // returns true if player moved.
    public boolean movePlayer(int x, int z) {
        if (checkCellEmpty(x, z) && !gameOver) {
            moveX(x, z);
            checkGameOver();
            if (!gameOver) {
                moveAI();
                checkGameOver();
            }
            return true;
        } else {
            return false;
        }
    }

    // returns true if moveAI is done, false if not moved.
    public boolean moveAI() {
        Random random = new Random();
        LinkedList<int[]> linkedList = new LinkedList<>();

        // find empty position, and enumerate positions
        for (int x = 1; x <= 3; x++) {
            for (int z = 1; z <= 3; z++) {
                if (checkCellEmpty(x, z)) {
//                    System.out.println("x:" + x + " z:" + z);
                    linkedList.add(new int[]{x, z});
                }
            }
        }

        // find random number in the number range, linked list
        // random number back to position coordinate

        int[] randomElement;
        try {
            randomElement = linkedList.get(random.nextInt(linkedList.size()));

//        System.out.println(Arrays.toString(randomElement));
//        System.out.println(Arrays.toString(linkedList.get(random.nextInt(linkedList.size()))));

        /*
        // to view list<int[]>
        System.out.println(linkedList);
        for (int[] int1 :
                linkedList) {
            System.out.println(Arrays.toString(int1));
        }
         */

            // Mark the coordinate with 'O', moveO(x,z)
            this.moveO(randomElement[0], randomElement[1]);
            return true;

        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    public String possiblemoves(){
        StringBuilder stringBuilder = new StringBuilder();

        // find empty position, and enumerate positions
        for (int x = 1; x <= 3; x++) {
            for (int z = 1; z <= 3; z++) {
                if (checkCellEmpty(x, z)) {
                    stringBuilder.append(x + ","+ z);
                    stringBuilder.append("\n");
                }
            }
        }
        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();
    }

    public boolean boardFull() {
        for (int x = 1; x <= 3; x++) {
            for (int z = 1; z <= 3; z++) {
                if (this.board[x][z] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public String checkGameOver() {
        // returns X win, O win, draw and over, not end.

        if (
            // vertical
                (board[1][1] == 'X' && board[1][2] == 'X' && board[1][3] == 'X')
                        || (board[2][1] == 'X' && board[2][2] == 'X' && board[2][3] == 'X')
                        || (board[3][1] == 'X' && board[3][2] == 'X' && board[3][3] == 'X')

                        // horizontal
                        || (board[1][1] == 'X' && board[2][1] == 'X' && board[3][1] == 'X')
                        || (board[1][2] == 'X' && board[2][2] == 'X' && board[3][2] == 'X')
                        || (board[1][3] == 'X' && board[2][3] == 'X' && board[3][3] == 'X')

                        // diagonal
                        || (board[1][1] == 'X' && board[2][2] == 'X' && board[3][3] == 'X')
                        || (board[1][3] == 'X' && board[2][2] == 'X' && board[3][1] == 'X')) {
            System.out.println("Player wins");
            gameOver = true;
            winner = "user";
            return "user";
        } else if (
            // vertical
                (board[1][1] == 'O' && board[1][2] == 'O' && board[1][3] == 'O')
                        || (board[2][1] == 'O' && board[2][2] == 'O' && board[2][3] == 'O')
                        || (board[3][1] == 'O' && board[3][2] == 'O' && board[3][3] == 'O')

                        // horizontal
                        || (board[1][1] == 'O' && board[2][1] == 'O' && board[3][1] == 'O')
                        || (board[1][2] == 'O' && board[2][2] == 'O' && board[3][2] == 'O')
                        || (board[1][3] == 'O' && board[2][3] == 'O' && board[3][3] == 'O')

                        // diagonal
                        || (board[1][1] == 'O' && board[2][2] == 'O' && board[3][3] == 'O')
                        || (board[1][3] == 'O' && board[2][2] == 'O' && board[3][1] == 'O')
        ) {
            System.out.println("Computer wins");
            gameOver = true;
            winner = "computer";
            return "computer";
        } else if (boardFull()) {
            System.out.println("Draw");
            gameOver = true;
            winner = "draw";
            return "draw";
        } else {
//            System.out.println("Continue");
            return "none";
        }
    }

    public static void main(String[] args) {
        TTT ttt = new TTT();

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

        ttt.possiblemoves();
    }
}
