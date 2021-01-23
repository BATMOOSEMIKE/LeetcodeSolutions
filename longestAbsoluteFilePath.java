class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> prevLengths = new Stack<Integer>();

        int longestPath = 0;
        int curChainLongest = 0;

        String[] items = input.split("\n");

        for(int i = 0; i < items.length; i++){
            String s = items[i];

            int level = 0;

            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '\t'){
                    level++;
                }
            }

            //level = how many nodes are "above" the current one in its chain
            while(prevLengths.size() > level){
                //backtrace cur chain length back to the "node" immediately before the current one
                curChainLongest -= prevLengths.pop();
            }

            int itemLength = s.length()-level;

            //s is a file
            if(s.contains(".")){
                curChainLongest += itemLength;
                prevLengths.push(itemLength);
                if(curChainLongest > longestPath){
                    longestPath = curChainLongest;
                }
            }
            //otherwise s is a directory
            else {
                //+ 1 for the / that must then be added on
                curChainLongest += itemLength + 1;
                prevLengths.push(itemLength+1);
            }
        }

        return longestPath;
    }


}
