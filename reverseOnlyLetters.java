class Solution {
    public String reverseOnlyLetters(String S) {
        String letters = "";
        String result = "";

        for(int i = 0; i < S.length(); i++) {
            if(isLetter(S.charAt(i))) {
                letters += S.charAt(i);
            }
        }

        int index = letters.length()-1;

        for(int i = 0; i < S.length(); i++) {
            if(isLetter(S.charAt(i))) {
                result += letters.charAt(index);
                index--;
            }
            else {
                result += S.charAt(i);
            }
        }

        return result;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}

/*

BETTER SOLUTION IS REVERSE POINTER: CAN DO IT IN ONE LOOP INSTEAD OF TWO.
Just loop through, when you run into a letter add the first letter you run into iterating from the back to result
If you run into a non letter just add it to result

*/
