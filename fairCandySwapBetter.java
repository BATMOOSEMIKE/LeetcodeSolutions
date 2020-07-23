class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int Asum = 0;
        int Bsum = 0;
        int[] ans = new int[2];

        Set<Integer> BSet = new HashSet();

        for(int i = 0; i < A.length; i++) {
            Asum += A[i];
        }
        for(int i = 0; i < B.length; i++) {
            Bsum += B[i];
            BSet.add(B[i]);
        }

        for(int i = 0; i < A.length; i++) {
            int needed = (Bsum - Asum)/2 + A[i];
            if(BSet.contains(needed)) {
                ans[0] = A[i];
                ans[1] = needed;
            }
        }

        return ans;
    }
}

//This is the better solution, O(A+B) time
