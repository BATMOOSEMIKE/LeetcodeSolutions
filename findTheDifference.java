class Solution {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for(int i = 0; i < sArray.length; i++){
            if(tArray[i] != sArray[i]){
                return tArray[i];
            }
        }

        return tArray[tArray.length-1];


    }
}
