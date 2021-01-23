class Solution {

    int totalWeighting;
    Random random;
    int[] arr;


    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            totalWeighting += w[i];
        }
        random = new Random();
        arr = w;
    }

    public int pickIndex() {
        int pickIndex = random.nextInt(totalWeighting) + 1;
        for(int i = 0; i < arr.length; i++){
            pickIndex -= arr[i];
            if(pickIndex <= 0){
                return i;
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
