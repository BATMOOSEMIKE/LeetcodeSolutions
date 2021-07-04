class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String firstWordInteger = convertToIntString(firstWord);
        String secondWordInteger = convertToIntString(secondWord);
        String thirdWordInteger = convertToIntString(targetWord);

        return Integer.parseInt(firstWordInteger) + Integer.parseInt(secondWordInteger) == Integer.parseInt(thirdWordInteger);
    }

    public String convertToIntString(String s){
        String res = "";
        for(char c: s.toCharArray()){
            res += c - 'a';
        }
        return res;
    }
}
