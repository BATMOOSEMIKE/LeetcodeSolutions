//Runtime O(N) where N is length of str
class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for(int i = 0; i < str.length(); i++){
            //Check if uppercase
            if(str.charAt(i) <= 'Z' && str.charAt(i) >= 'A'){
                //There is a 32 int difference between 'A' and 'a'
                sb.append((char) (str.charAt(i) + 32));
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
