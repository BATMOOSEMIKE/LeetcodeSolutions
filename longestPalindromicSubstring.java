//O(n^2) runtime by expanding around all singles and all doubles that are palindromes
//brute force would be O(n^3) because checking for palindrome takes n time, and we have n^2 substrings

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        String longest = "";

        //start from all singles
        for(int i = 0; i < s.length(); i++){
            int span = 0;
            while(i + span < s.length() && i - span >= 0 && s.charAt(i+span) == s.charAt(i-span))  {
                span++;
            }
            if(longest.length() < i+span-1 - (i-span)){
                longest = s.substring(i-span+1, i+span);
            }
        }
        //start from all doubles
        for(int i = 0; i < s.length()-1; i++){
            //if this pair is a palindrome:
            if(s.charAt(i) == s.charAt(i+1)){
                int span = 0;
                while(i-span >= 0 && i+1+span < s.length() && s.charAt(i-span) == s.charAt(i+span+1)){
                    span++;
                }
                if(longest.length() < 2 + 2*(span-1)){
                    longest = s.substring(i-span+1, i+1+span);
                }
            }
        }

        return longest;
    }
}
