class Solution {
    public boolean validPalindrome(String s) {
        boolean strike = false;
        int forwardPtr = 0;
        int backwardPtr = s.length()-1;
        while(forwardPtr <= backwardPtr){
            if(s.charAt(forwardPtr) != s.charAt(backwardPtr)){
                System.out.println(s.substring(forwardPtr+1, backwardPtr+1));
                System.out.println(s.substring(forwardPtr, backwardPtr));
                return strictPalindrome(s.substring(forwardPtr+1, backwardPtr+1)) || strictPalindrome(s.substring(forwardPtr, backwardPtr));
                // System.out.println(s.charAt(forwardPtr) + " " + s.charAt(backwardPtr));
                // if(strike){
                //     return false;
                // }
                // //try "deleting" the character that isn't working
                // else if(forwardPtr < s.length()-2 && s.charAt(forwardPtr+1) == s.charAt(backwardPtr)){
                //     strike = true;
                //     forwardPtr++;
                // }
                // else if(backwardPtr > 0 && s.charAt(backwardPtr-1) == s.charAt(forwardPtr)){
                //     strike = true;
                //     backwardPtr--;
                // }
                // else {
                //     return false;
                // }
            }
            else {
                forwardPtr++;
                backwardPtr--;
            }
        }
        return true;
    }

    public boolean strictPalindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
