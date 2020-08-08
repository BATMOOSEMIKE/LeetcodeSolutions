//O(N*S) where N is length of A and S is length of every individual string

class Solution {
    public int minDeletionSize(String[] A) {
        int count = 0;

        for(int i = 0; i < A[0].length(); i++){
            for(int j = 0; j < A.length-1; j++){
                if(A[j+1].charAt(i) < A[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
