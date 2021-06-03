//O(N*m) runtime, O(1) space
//use the first element of each row/column as a variable to see if that row/col has 0s
//two separate variables for first row and column

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        //check first col for zeroes
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
            }

        }

        //check first row
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        //iterate through all rows except first row
        for(int i = matrix.length-1; i >= 1; i--){
            if(matrix[i][0] == 0){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //iterate through all columns except first column
        for(int i = 1; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        //check first row
        if(firstRow){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        //check first column
        if(firstCol){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }


    }
}
