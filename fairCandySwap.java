class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int Asum = 0;
        int Bsum = 0;

        for(int i = 0; i < A.length; i++) {
            Asum += A[i];
        }
        for(int i = 0; i < B.length; i++) {
            Bsum += B[i];
        }

        int[] ans = new int[2];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if((Asum-Bsum)/2 == A[i] - B[j]) {
                    ans[0] = A[i];
                    ans[1] = B[j];
                    return ans;
                }
            }
        }

        return ans;
    }
}

/*
Runtime of O(length(A) * length(B)) can be made into O(length(A) + length(B)) by putting B into a set
*/
