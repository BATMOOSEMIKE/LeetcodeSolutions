//Could be done with stacks or arraylists, both have O(1) size lookup time
//This solution has runtime of O(N)
class Solution {
    public int balancedStringSplit(String s) {
        ArrayList<String> rights = new ArrayList<String>();
        ArrayList<String> lefts = new ArrayList<String>();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'R'){
                rights.add("R");
            }
            else {
                lefts.add("L");
            }
            if(lefts.size() == rights.size()) {
                count++;
            }
        }

        return count;
    }
}
