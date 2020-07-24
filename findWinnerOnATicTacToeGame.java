class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];

        for(int i = 0; i < moves.length; i++) {
            if(i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 1;
            }
            else {
                board[moves[i][0]][moves[i][1]] = 2;
            }
        }

        if(didAWin(board)) {
            return "A";
        }
        if(didBWin(board)) {
            return "B";
        }
        if(moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }

    //As moves are represented as 1
    public boolean didAWin(int[][] board) {
        return((board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1)||
               (board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) ||
               (board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) ||
               (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1) ||
               (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1) ||
               (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1) ||
               (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1) ||
               (board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1));
    }

    //Bs moves are represented as 2
    public boolean didBWin(int[][] board) {
        return((board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) ||
               (board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) ||
               (board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2) ||
               (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2) ||
               (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2) ||
               (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2) ||
               (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2) ||
               (board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2));
    }
}
