//O(n) runtime using sliding windows approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<Character>();
        char[] str = s.toCharArray();

        if(str.length == 0){
            return 0;
        }

        int longest = 0;

        int left = 0;
        int right = 0;
        while(right < str.length){
            //we need to start shrinking left side
            if(seen.contains(str[right])){
                longest = Math.max(longest, right-left);
                while(str[left] != str[right]){
                    seen.remove(str[left]);
                    left++;
                }
                seen.remove(str[left]);
                left++;
            }
            else {
                seen.add(str[right]);
                right++;
            }
        }

        longest = Math.max(longest, right-left);
        return longest;
    }
}
