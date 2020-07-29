//Runtime O(N^2) where N is the length of the chess board

class Solution {
    public int numRookCaptures(char[][] board) {
        int rookx = 0;
        int rooky = 0;
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R') {
                    rookx = j;
                    rooky = i;
                }
            }
        }

        for(int i = rooky; i < board.length; i++) {
            if(board[i][rookx] == 'B') {
                break;
            }
            if(board[i][rookx] == 'p') {
                count++;
                break;
            }
        }

        for(int i = rooky; i >= 0; i--) {
            if(board[i][rookx] == 'B') {
                break;
            }
            if(board[i][rookx] == 'p') {
                count++;
                break;
            }
        }

        for(int i = rookx; i < board[0].length; i++) {
            if(board[rooky][i] == 'B') {
                break;
            }
            if(board[rooky][i] == 'p') {
                count++;
                break;
            }
        }

        for(int i = rookx; i >= 0; i--) {
            if(board[rooky][i] == 'B') {
                break;
            }
            if(board[rooky][i] == 'p') {
                count++;
                break;
            }
        }

        return count;
    }
}
