//Runtime O(N) where N is length of s
class Solution {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        for(int i = 0; i < indices.length; i++){
            result[indices[i]] = s.charAt(i);
        }
        String resultString = new String(result);
        return resultString;
    }
}
