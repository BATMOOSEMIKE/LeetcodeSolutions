//O(N) runtime technically because the array is size 26 max

class Solution {
    public String reorganizeString(String s) {
        //a maps to 0, z maps to 26
        int[] charCounts =  new int[26];

        for(int i = 0; i < s.length(); i++){
            charCounts[s.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        char prev = 'A';

        for(int i = 0; i < s.length(); i++){
            char next = getCandidate(charCounts, prev);
            if(next == 'A'){
                return "";
            }
            res.append(next);
            prev = next;
        }

        return res.toString();
    }

    public char getCandidate(int[] charCounts, char prev){
        int max = 0;
        char toReturn = 'A';
        for(int i = 0; i < charCounts.length; i++){
            if(charCounts[i] > max && i != prev-'a'){
                toReturn = (char) (i+'a');
                max = charCounts[i];
            }
        }
        //decrement count
        if(toReturn != 'A'){
            charCounts[toReturn-'a']--;
        }
        return toReturn;
    }
}
