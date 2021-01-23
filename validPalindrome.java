class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        s = onlyAlphaNumeric(s);
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public String onlyAlphaNumeric(String s){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((c <= '9' && c >= '0') || (c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')){
                str.append(c);
            }
        }
        return str.toString();
    }
}
