/*
Cracking The Coding Interview - 6th Edition. Page 181.

Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic-tac-toe.
*/

package careercup.moderate;

import helpers.java.Inputs;

public class TicTacWin {
    private int[][] board;
    private int[][] counts;

    public TicTacWin(int size) {
        board = new int[size][size];
        counts = new int[size + 1][2];
    }

    public void fillBoard(int[][] board) {
        this.board = board;
        int size = this.board.length;

        for(int i = 0; i < size; i++) {
            int countRow = 0;
            for(int j = 0; j < size; j++) {
                countRow += this.board[i][j];
            }
            this.counts[i][0] = countRow;

            int countCol = 0;
            for(int j = 0; j < size; j++) {
                countCol += this.board[j][i];
            }
            this.counts[i][1] = countCol;
        }

        int leftCrossCount = 0;
        int rightCrossCount = 0;
        for(int i = 0; i < size; i++) {
            leftCrossCount += this.board[i][i];
            rightCrossCount += this.board[i][size - 1 - i];
        }

        this.counts[size][0] = leftCrossCount;
        this.counts[size][1] = rightCrossCount;
    }

    public void printCounts() {
        int size = this.counts.length;
        for(int i = 0; i < size; i++) {
            System.out.println(this.counts[i][0] + " " + this.counts[i][1]);
        }
    }

    public char whoWins() {
        int size = this.board.length;

        for(int i = 0; i < size + 1; i++) {
            int countRow = this.counts[i][0];
            int countCol = this.counts[i][1];

            if(countRow % 3 == 0) {
                return countRow > 0 ? 'x' : 'o';
            } else if(countCol % 3 == 0) {
                return countCol > 0 ? 'x' : 'o';
            }
        }

        return 'd';
    }

    public static void main(String[] args) {
        String[] lines = Inputs.readAllInputs();
        int size = Integer.parseInt(lines[0]);
        int[][] board = new int[size][size];

        for(int i = 0; i < size; i++) {
            Integer[] row = Inputs.createArrayOfIntegers(lines[i + 1]);

            for(int j = 0; j < size; j++)
            {
                board[i][j] = row[j];
            }
        }

        TicTacWin game = new TicTacWin(size);
        game.fillBoard(board);
        game.printCounts();

        char c = game.whoWins();
        if(c == 'x') {
            System.out.println("X wins the game.");
        } else if(c == 'o') {
            System.out.println("O wins the game.");
        } else {
            System.out.println("Game is a draw!");
        }
    }
}
