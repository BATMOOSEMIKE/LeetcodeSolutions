class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashMap<String, Boolean> memo = new HashMap<String, Boolean>();

        for(String str: wordDict){
            memo.put(str, true);
        }

        return wordBreakMemo(s, memo);
    }

    public boolean wordBreakMemo(String s, HashMap<String, Boolean> memo){
        //base case
        if(s.length() == 0){
            return true;
        }

        if(memo.containsKey(s)){
            return memo.get(s);
        }

        for(int i = 1; i < s.length(); i++){
            String rem1 = s.substring(0,i);
            String rem2 = s.substring(i);

            if(wordBreakMemo(rem1, memo) && wordBreakMemo(rem2, memo)){
                memo.put(s, true);
                return true;
            }
        }

        memo.put(s, false);
        return false;
    }
}
