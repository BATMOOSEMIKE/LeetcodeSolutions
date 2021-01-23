class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int layers = (n+1)/2;

        //loop through each layer
        for(int i = 0; i < layers; i++){
            int layerSize = n-i*2;
            int topCoord = i;
            int leftCoord = i;
            int bottomCoord = i + layerSize - 1;
            int rightCoord = i + layerSize - 1;
            //loop through each element of each layer
            for(int j = 0; j < layerSize-1; j++){
                //store top left element as a temporary variable
                int temp = matrix[i][i+j];
                //top "left" = "bottom" left
                matrix[i][i+j] = matrix[i+layerSize-1-j][i];
                //"bottom" left = bottom "right"
                matrix[i+layerSize-1-j][i] = matrix[i+layerSize-1][i+layerSize-1-j];
                //bottom "right" = "top" right
                matrix[i+layerSize-1][i+layerSize-1-j] = matrix[i+j][i+layerSize-1];
                //"top" right = top "left"
                matrix[i+j][i+layerSize-1] = temp;
            }
        }
    }
}
