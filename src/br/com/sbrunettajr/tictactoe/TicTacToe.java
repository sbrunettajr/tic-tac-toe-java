package br.com.sbrunettajr.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private Board board;

    private Player player1;
    private Player player2;
    private Player nextPlayer;

    private Scanner scanner;

    private int counter;

    public TicTacToe() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    private void inputPlayers() {
        player1 = inputPlayer("X");
        player2 = inputPlayer("O");
        nextPlayer = player1;
    }

    private Player inputPlayer(String option) {
        System.out.printf("Digite o nome do jogador(%s): ", option);
        String nickname = scanner.nextLine();
        if (nickname.isBlank()) {
            return inputPlayer(option);
        }
        return new Player(nickname, option);
    }

    private void changePlayer() {
        nextPlayer = (nextPlayer == player1) ? player2 : player1;
    }

    private void printNextPlayer() {
        System.out.printf("Jogador %s(%s): ", nextPlayer.getNickname(), nextPlayer.getOption());
    }

    private void printResult() {
        board.print();
        System.out.printf("Jogador vencedor: %s(%s)", nextPlayer.getNickname(), nextPlayer.getOption());
    }

    private int inputCell() {
        int cell = scanner.nextInt();
        scanner.nextLine();
        return cell;
    }

    private boolean isCellValid(int cell) {
        return board.isCellValid(cell) && board.isCellEmpty(cell);
    }

    private void incrementCounter() {
        counter += 1;
    }

    private boolean finishedGame() {
        return counter == 9;
    }

    private void destruct() {
        scanner.close();
    }

    public void play() {
        inputPlayers();
        do {
            board.print();
            printNextPlayer();
            int cell = inputCell();
            if (isCellValid(cell)) {
                board.markCell(nextPlayer, cell);
                incrementCounter();
                if (board.hasWinner()) {
                    printResult();
                    break;
                }
                changePlayer();
            }
        } while(!finishedGame());
        destruct();
    }



}
