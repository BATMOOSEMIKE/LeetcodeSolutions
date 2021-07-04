//O(s+t) where s is length of s and t is length of t using sliding window solution
class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        int minL = Integer.MAX_VALUE;
        //first make a hashmap with all char counts of t
        HashMap<Character, Integer> tCounts = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(tCounts.containsKey(c)){
                tCounts.put(c, tCounts.get(c)+1);
            }
            else{
                tCounts.put(c, 1);
            }
        }

        int numToMatch = tCounts.size();
        int curMatching = 0;
        //initialize left and right pointers to 0
        int l = 0;
        int r = 0;
        //the window is from char at l to char at r
        HashMap<Character, Integer> winCounts = new HashMap<Character, Integer>();
        //make a hashmap with all char counts of cur window
        //note we only need to keep track of all relevant char counts (chars that are in t)

        //move window, checking for match each time
        while(r < s.length()){
            //System.out.println(l + " " + r + " " + res);
            char newC = s.charAt(r);
            if(tCounts.containsKey(newC)){
                int curCount = winCounts.getOrDefault(newC, 0);
                winCounts.put(newC, curCount+1);
                if(curCount+1 == tCounts.get(newC)){
                    //System.out.println("Increasing cur matching to " + (curMatching+1) + " after adding " + newC);
                    curMatching++;
                }
            }
            //move left
            while(curMatching == numToMatch){
                //System.out.println(l + " " + r + " " + res);
                //when the cur window is the smallest answer, update return value
                if(r-l+1 < minL){
                    res = s.substring(l, r+1);
                    minL = r-l+1;
                }
                //check if we are still matching all chars
                char delChar = s.charAt(l);
                if(tCounts.containsKey(delChar)){
                    int curCount = winCounts.get(delChar);
                    winCounts.put(delChar, curCount-1);
                    if(curCount-1 < tCounts.get(delChar)){
                        //System.out.println("Decreasing cur matching to " + (curMatching-1) + " after deleting " + delChar);
                        curMatching--;
                    }
                }
                l++;
            }
            r++;
        }

        return res;

    }
}
