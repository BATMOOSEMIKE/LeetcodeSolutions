//O(nlogn) solution using Dynamic Programming, because doing Math.log takes log runtime
//O(n) solution possible with a math trick -
//if i is odd, then ans[i] should be ans[i-1] + 1
//if i is 2^x, then ans[i] should be 1
//else (even and not 2^x), ans[i] = ans[i/2] because multiplying a num by 2 in binary is same as left shift

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;

        for(int i = 1; i <= n; i++){
            int e = (int) (Math.log(i)/Math.log(2));
            int rem = i - (int)Math.pow(2, e);
            ans[i] = 1+ ans[rem];
        }

        return ans;
    }
}
