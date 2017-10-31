package com.sample.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a board size: [2 - 10]" );
//        int boardSize = Integer.parseInt(args[0]); //scanner.nextInt();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        try {
            int boardSize = Integer.parseInt(s);
            TTT ticTacToe = new TTT(boardSize);
            ticTacToe.startGame();
        }
        catch (Exception e) {
            System.out.println("Illegal board size" );
        }
        finally {
            scanner.close();
        }
    }
}
