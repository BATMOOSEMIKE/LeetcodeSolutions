class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(carry != 0 || aIndex >= 0 || bIndex >= 0) {
            if(aIndex >= 0) {
                carry += a.charAt(aIndex) - '0';
                aIndex--;
            }
            if(bIndex >= 0) {
                carry += b.charAt(bIndex) - '0';
                bIndex--;
            }

            sb.append(carry%2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}
