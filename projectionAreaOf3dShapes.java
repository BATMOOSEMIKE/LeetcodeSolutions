class Solution {
    public int projectionArea(int[][] grid) {
        int size = 0;

        for(int i = 0; i<grid.length;i++){
            int rowsize = 0;
            for(int j = 0; j<grid[i].length;j++){
                if(grid[i][j] != 0){
                    rowsize++;
                }
            }

            size += rowsize;
        }


        int max = 0;
        for(int i = 0; i<grid.length;i++){
            max = 0;
            for(int j = 0; j<grid[i].length; j++){
                if (grid[i][j]>max){
                    max = grid[i][j];
                }
            }
            size += max;
        }

        for(int i = 0; i<grid[0].length;i++){
            max = 0;
            for(int j = 0; j<grid.length; j++){
                if (grid[j][i]>max){
                    max = grid[j][i];
                }
            }
            size += max;
        }

        return size;


    }
}
