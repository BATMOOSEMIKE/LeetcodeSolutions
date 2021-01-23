class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allSolutions = new ArrayList<List<String>>();


        //0 is neutral, -1 means you can't put a queen there, 1 means a queen is there
        int[][] board = new int[n][n];
        dfs(board, 0, allSolutions);
        return allSolutions;

    }

    public void dfs(int[][] board, int rowNum, List<List<String>> s){
        int n = board.length;
        if(rowNum == n){
            s.add(listForm(board));
        }
        else {
            for(int i = 0; i < n; i++){
                if(possible(board, rowNum, i)){
                    board[rowNum][i] = 1;
                    dfs(board, rowNum+1, s);
                    board[rowNum][i] = 0;
                }
            }
        }
    }

    public List<String> listForm(int[][] board){
        List<String> res = new ArrayList<String>();

        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }

    public boolean possible(int[][] board, int i, int j){
        int n = board.length;

        for(int a = 0; a < n; a++){
            if(board[a][j] == 1 || board[i][a] == 1){
                return false;
            }
        }

        for(int offset = 0; offset < n; offset++){
            if(i+offset < n && j + offset < n){
                if(board[i+offset][j+offset] == 1){
                    return false;
                }
            }
            if(i+offset < n && j - offset >= 0){
                if(board[i+offset][j-offset] == 1){
                    return false;
                }
            }
            if(i - offset >= 0 && j + offset < n){
                if(board[i-offset][j+offset] == 1){
                    return false;
                }
            }
            if(i - offset >= 0 && j - offset >= 0){
                if(board[i-offset][j-offset] == 1){
                    return false;
                }
            }
        }

        return true;
    }


}
