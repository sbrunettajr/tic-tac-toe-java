package br.com.sbrunettajr.tictactoe;

public class Board {

    private final String[][] board = new String[3][3];

    public Board() {
        for (int i = 0; i < 9; i++) {
            int x = i / 3;
            int y = i % 3;
            board[x][y] = String.valueOf(i);
        }
    }

    public void print() {
        for (int y = 0; y < 3; y++) {
            StringBuilder row = new StringBuilder("[ ");
            for (int x = 0; x < 3; x++) {
                row.append(board[y][x]);
                if (x != 2) {
                    row.append(", ");
                }
            }
            row.append(" ]");
            System.out.println(row);
        }
    }

    public boolean isCellValid(int cell) {
        return cell >= 0 && cell <= 8;
    }

    public boolean isCellEmpty(int cell) {
        try {
            int x = cell / 3;
            int y = cell % 3;
            Integer.parseInt(board[x][y]);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public void markCell(Player player, int cell) {
        int x = cell / 3;
        int y = cell % 3;
        board[x][y] = player.getOption();
    }

    public boolean hasWinner() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) || checkColumn(i)) {
                return true;
            }
        }
        return checkDiagonal();
    }

    private boolean checkRow(int i) {
        return board[i][0] == board[i][1] && board[i][1] == board[i][2];
    }

    private boolean checkColumn(int i) {
        return board[0][i] == board[1][i] && board[1][i] == board[2][i];
    }

    private boolean checkDiagonal() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

}
