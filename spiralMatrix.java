//O(m*n) runtime, O(1) space if not counting the returned ArrayList
//go layer by layer, like an onion

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftCol = 0;
        int rightCol = matrix[0].length-1;
        int topRow = 0;
        int botRow = matrix.length-1;

        List<Integer> elems = new ArrayList<Integer>();

        while(leftCol <= rightCol && topRow <= botRow){
            //grab top row
            for(int i = leftCol; i <= rightCol; i++){
                elems.add(matrix[topRow][i]);
            }
            //grab right col minus the top element
            for(int i = topRow+1; i <= botRow; i++){
                elems.add(matrix[i][rightCol]);
            }

            //check if we have more than one row and one col
            if(leftCol < rightCol && topRow < botRow){
                //grab bot row minus the rightmost element
                for(int i = rightCol-1; i >= leftCol; i--){
                    elems.add(matrix[botRow][i]);
                }
                //grab left col minus the top and bot elements
                for(int i = botRow-1; i >= topRow+1; i--){
                    elems.add(matrix[i][leftCol]);
                }
            }

            //update leftCol, rightCol, topRow, botRow to go in one layer
            leftCol++;
            rightCol--;
            topRow++;
            botRow--;
        }

        return elems;
    }
}
