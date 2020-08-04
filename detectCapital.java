//O(N) where N is length of word. marginally better than running the loop three times

class Solution {
    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))) {
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        else if(word.length() > 1 && Character.isLowerCase(word.charAt(1))){
            for(int i = 2; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        else {
            for(int i = 1; i < word.length(); i++){
                if(Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
