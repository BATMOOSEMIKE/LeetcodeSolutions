import java.util.*;

//Runtime O((KNlogN))
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for(int i = 0; i < K; i++){
            A[0] = -A[0];
            Arrays.sort(A);
        }
        return sum(A);
    }

    public int sum(int[] array) {
        int count = 0;
        for(int i = 0; i < array.length; i++){
            count += array[i];
        }
        return count;
    }


}
