//My first medium question!!
import java.lang.Math;

class Solution {
    public void rotate(int[][] matrix) {
        int[][] newmatrix = new int[matrix.length][matrix.length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                newmatrix[j][Math.abs(matrix.length-i-1)] = matrix[i][j];
            }
        }

        for(int i = 0; i < newmatrix.length; i++){
          for(int j = 0; j < newmatrix.length; j++){
            matrix[i][j] = newmatrix[i][j];
          }
        }

    }
}
