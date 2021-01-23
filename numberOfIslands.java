class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        //row #
        for(int i = 0; i < grid.length; i++){
            //col #
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    destroy(grid, i, j);
                }
            }
        }

        return count;
    }

    public void destroy(char[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            destroy(grid, i-1,j);
            destroy(grid, i+1,j);
            destroy(grid, i, j-1);
            destroy(grid, i, j+1);
        }
    }
}
