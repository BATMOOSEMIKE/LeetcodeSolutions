//dfs and dp solution

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];

        int max = 0;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, 1 + longestIncreasingFrom(matrix, i, j, new boolean[matrix.length][matrix[0].length], memo));
            }
        }

        return max;
    }

    public int longestIncreasingFrom(int[][] matrix, int row, int col, boolean[][] visited, int[][] memo){
        visited[row][col] = true;
        //if this coord has already been checked (in memo), just return that
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        //otherwise return max of the possible directions we can go
        int length = 0;
        if(canGo(matrix, row-1, col, visited) && matrix[row-1][col] > matrix[row][col]){
            // System.out.println("checking up comparing: " + matrix[row-1][col] +" to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row-1, col, visited, memo));
        }
        if(canGo(matrix, row+1, col, visited) && matrix[row+1][col] > matrix[row][col]){
            // System.out.println("checking down comparing " + matrix[row+1][col] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row+1, col, visited, memo));
        }
        if(canGo(matrix, row, col-1, visited) && matrix[row][col-1] > matrix[row][col]){
            // System.out.println("checking left comparing " + matrix[row][col-1] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row, col-1, visited, memo));
        }
        if(canGo(matrix, row, col+1, visited) && matrix[row][col+1] > matrix[row][col]){
            // System.out.println("checking right comparing " + matrix[row][col+1] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row, col+1, visited, memo));
        }

        memo[row][col] = length;
        visited[row][col] = false;
        return length;
    }

    public boolean canGo(int[][] matrix, int row, int col, boolean[][] visited){
        if(row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 && !visited[row][col]){
            return true;
        }
        return false;
    }


}class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];

        int max = 0;

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, 1 + longestIncreasingFrom(matrix, i, j, new boolean[matrix.length][matrix[0].length], memo));
            }
        }

        return max;
    }

    public int longestIncreasingFrom(int[][] matrix, int row, int col, boolean[][] visited, int[][] memo){
        visited[row][col] = true;
        //if this coord has already been checked (in memo), just return that
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        //otherwise return max of the possible directions we can go
        int length = 0;
        if(canGo(matrix, row-1, col, visited) && matrix[row-1][col] > matrix[row][col]){
            // System.out.println("checking up comparing: " + matrix[row-1][col] +" to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row-1, col, visited, memo));
        }
        if(canGo(matrix, row+1, col, visited) && matrix[row+1][col] > matrix[row][col]){
            // System.out.println("checking down comparing " + matrix[row+1][col] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row+1, col, visited, memo));
        }
        if(canGo(matrix, row, col-1, visited) && matrix[row][col-1] > matrix[row][col]){
            // System.out.println("checking left comparing " + matrix[row][col-1] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row, col-1, visited, memo));
        }
        if(canGo(matrix, row, col+1, visited) && matrix[row][col+1] > matrix[row][col]){
            // System.out.println("checking right comparing " + matrix[row][col+1] + " to " + matrix[row][col]);
            length = Math.max(length, 1 + longestIncreasingFrom(matrix, row, col+1, visited, memo));
        }

        memo[row][col] = length;
        visited[row][col] = false;
        return length;
    }

    public boolean canGo(int[][] matrix, int row, int col, boolean[][] visited){
        if(row < matrix.length && row >= 0 && col < matrix[0].length && col >= 0 && !visited[row][col]){
            return true;
        }
        return false;
    }


}
