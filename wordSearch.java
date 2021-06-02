//This is a recursive DFS Solution
//runtime is O(m*n) where m and n are the dimensions of the board


class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(existsHelper(board, word.substring(1), visited, i, j)){
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }

        return false;
    }

    //this dfs helper will check for word[0] at the neighbors of point (x,y)
    public boolean existsHelper(char[][] board, String word, boolean [][] visited, int r, int c){
        //if string is empty we are done
        if(word.length() == 0){
            return true;
        }


        //otherwise lets keep searching

        //check up
        if(r-1 >= 0 && !visited[r-1][c] && board[r-1][c] == word.charAt(0)){
            visited[r-1][c] = true;
            if(existsHelper(board, word.substring(1), visited, r-1, c)){
                return true;
            }
            visited[r-1][c] = false;
        }

        //check down
        if(r+1 < board.length && !visited[r+1][c] && board[r+1][c] == word.charAt(0)){
            visited[r+1][c] = true;
            if(existsHelper(board, word.substring(1), visited, r+1, c)){
                return true;
            }
            visited[r+1][c] = false;
        }

        //check left
        if(c-1 >= 0 && !visited[r][c-1] && board[r][c-1] == word.charAt(0)){
            visited[r][c-1] = true;
            if(existsHelper(board, word.substring(1), visited, r, c-1)){
                return true;
            }
            visited[r][c-1] = false;
        }

        //check right
        if(c + 1 < board[0].length && !visited[r][c+1] && board[r][c+1] == word.charAt(0)){
            visited[r][c+1] = true;
            if(existsHelper(board, word.substring(1), visited, r, c+1)){
                return true;
            }
            visited[r][c+1] = false;
        }

        return false;
    }

}
