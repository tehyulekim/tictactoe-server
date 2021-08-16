package assignment2_server_14068171.server;

/*

This is example TTT from
https://www.youtube.com/watch?v=R51BIlAt_Hg&list=PLQEWImtzN6YkA3u17r8RygigzFaiXjzNm&index=4&t=3s


https://www.instructables.com/id/How-to-Write-a-Tic-Tac-Toe-Program-in-Java/

 */

import java.util.Scanner;

public class TTT1 {
    public static Scanner scanner = new Scanner(System.in);
    public static int row, col;
    public static char[][] board = new char[3][3];
    public static char turn = 'X';

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        PrintBoard();
        Play();
    }


    public static void Play() {
        boolean playing = true;
        while (playing) {
            System.out.println("Enter row and column ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            board[row][col] = turn;
            if (GameOver(row, col)) {
                playing = false;
                System.out.println(turn + " wins! ");
            }

            PrintBoard();

            if (turn == 'X')
                turn = 'O';
            else
                turn = 'X';
        }
    }


    public static void PrintBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
    }

    public static boolean GameOver(int rMove, int cMove) {
        // Check perpendicular victory
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove])
            return true;
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2])
            return true;

        // Check diagonal victory
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
            return true;

        return false;
    }
}
