//O(N) where N is the length of s

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i < (s.length+1)/2; i++){
            char front = s[i];
            char back = s[s.length-1-i];

            s[i] = back;
            s[s.length-1-i] = front;
        }
    }
}
