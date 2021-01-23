class Solution {
    public int numDecodings(String s) {
        int prev = 1;
        int nextPrev = 0;
        char prevChar = '0';

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '0' && prevChar == '0'){
                return 0;
            }
            else if(c == '0'){
                if(prevChar != '1' && prevChar != '2'){
                    return 0;
                }
                int newPrev = nextPrev;
                nextPrev = prev;
                prev = newPrev;
            }
            else if(prevChar == '0'){
                nextPrev = prev;
            }
            else{
                if(prevChar == '1'){
                    int newPrev = prev + nextPrev;
                    nextPrev = prev;
                    prev = newPrev;
                }
                else if(prevChar == '2' && c >= '1' && c <= '6'){
                    int newPrev = prev + nextPrev;
                    nextPrev = prev;
                    prev = newPrev;
                }
                else {
                    nextPrev = prev;
                }
            }
            prevChar = c;
        }

        return prev;

        //new idea
        //keep track of numways to make previous
        //keep track of numways to make previous-1
        //keep track of last char
        //cases:
        //if new char is not 0 and last char is not 0
        //return nums[i-1] + nums[i-2] if last is 1 or both last is 2 and cur is 6<
        //if new char is 0 and last char is not 0
        //check if last char is 1 or 2, if not then we return 0 and if so then nums[i-2]
        //if new char is 0 and last char is 0
        //return 0
        //if new char is not 0 and last char is 0
        //then we return nums[i-1]

    }

}
