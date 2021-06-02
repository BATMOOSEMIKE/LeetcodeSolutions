//dp solution, memoizing which substrings are palindromes in a set and then iterating through
//all possible substrings so the runtime is O(N^2) because checking for palindromes
//takes O(1) time amortized

class Solution {
    public int countSubstrings(String s) {
        Set<String> setOfP = new HashSet<String>();
        int count = 0;

        //loop through all possible substring sizes, starting with 1
        for(int i = 1; i <= s.length(); i++){
            //loop through all possible starting indices
            for(int j = 0; j < s.length() + 1 - i; j++){
                String substr = s.substring(j, j+i);
                if(isPalindrome(substr, setOfP)){
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPalindrome(String s, Set<String> set){
        if(set.contains(s)){
            return true;
        }
        else if(s.length() == 0 || s.length() == 1){
            set.add(s);
            return true;
        }

        else if(s.charAt(0) == s.charAt(s.length()-1)){
            if(isPalindrome((s.substring(1,s.length()-1)), set)){
                set.add(s);
                return true;
            }
        }

        return false;

    }
}
