class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N];
        int[] trustedCount = new int[N];

        for(int i = 0; i < trust.length; i++){
            int truster = trust[i][0];
            int trusted = trust[i][1];

            trustCount[truster-1]++;
            trustedCount[trusted-1]++;
        }

        for(int i = 0; i < N; i++){
            if(trustCount[i] == 0 && trustedCount[i] == N-1){
                return i+1;
            }
        }

        return -1;
    }
}
