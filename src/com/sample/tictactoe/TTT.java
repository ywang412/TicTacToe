package com.sample.tictactoe;

import java.util.*;

/**
 * Created by yu wang on 10/31/17.
 */
public class TTT {

    private char[][] board;
    private char[] players;
    private int currentPlayer;
    private int winner;
    private Set<Integer> remainingPositions = new HashSet<Integer>();
    private int boardWidth;


    public TTT(int boardWidth) {
        if (boardWidth >= 2 && boardWidth <= 10) {
            this.boardWidth = boardWidth;
            board =  new char[boardWidth][boardWidth];
            for (int i = 0; i < boardWidth; i++) {
                for (int j = 0; j < boardWidth; j++) {
                    board[i][j] = '#';
                    remainingPositions.add(i * boardWidth + j);
                }
            }
            players = new char[]{'X', 'O'};
            winner = -1;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public void startGame() {
        Random rand = new Random();
        currentPlayer = rand.nextInt(2);
        System.out.println(players[currentPlayer] + " goes first" );
        while (userPlay()) {
            currentPlayer = (currentPlayer + 1) % 2;
        }
        printBoard();
        if (winner >= 0) {
            System.out.println(players[currentPlayer] + " won!");
        }
        else {
            System.out.println("It was a draw.");
        }
    }

    public boolean isBoardFull() {
        return remainingPositions.size() == 0;
    }

    public boolean userPlay() {
        Random rand = new Random();
        int rn = rand.nextInt(remainingPositions.size());
        List<Integer> list = new ArrayList(remainingPositions);
        int position = list.get(rn);
        remainingPositions.remove(position);
        int i = position / boardWidth;
        int j = position % boardWidth;
        board[i][j] = players[currentPlayer];
        if (checkWinner(i, j)) {
            winner = currentPlayer;
            return false;
        }
        if (isBoardFull()) {
            return false;
        }
        return true;
    }

    public boolean checkWinner(int i, int j) {
        return checkRow(i, j) || checkColumn(i, j) || checkDiagonal(i, j);
    }

    public void printBoard() {
        for (int i = 0; i < boardWidth; i++) {
            String s = new String();
            for (int j = 0; j < boardWidth; j++) {
                s += board[i][j];
            }
            System.out.println(s);
        }
    }

    public boolean checkRow(int i, int j) {
        char p = board[i][j];
        for (int k = 0; k < boardWidth; k++) {
            if (board[i][k] != p) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(int i, int j) {
        char p = board[i][j];
        for (int k = 0; k < boardWidth; k++) {
            if (board[k][j] != p) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonal(int i, int j) {
        if (i != j || i != boardWidth - 1 - j) {
            return false;
        }
        char p = board[i][j];
        boolean diagonalNW = true;
        for (int k = 0; k < boardWidth; k++) {
            if (board[k][k] != p) {
                diagonalNW = false;
            }
        }
        boolean diagonalSW = true;
        for (int k = 0; k < boardWidth; k++) {
            if (board[k][boardWidth - 1 - k] != p) {
                diagonalSW = false;
            }
        }
        return diagonalNW || diagonalSW;
    }
}
