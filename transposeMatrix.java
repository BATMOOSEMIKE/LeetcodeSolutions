class Solution {
    public int[][] transpose(int[][] A) {

        int[][] transposedVersion = new int[A[0].length][A.length];
        for (int i = 0; i<A[0].length;i++){
            for(int j = 0; j<A.length;j++){
                transposedVersion[i][j] = A[j][i];
            }
        }

        return transposedVersion;
    }


}
