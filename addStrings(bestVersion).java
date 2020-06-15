/*
STUDY THIS SOLUTION, IT'S WAY MORE EFFICIENT!
*/

class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length()-1;
        int p2 = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(carry != 0 || (p1 >= 0) || p2 >= 0){
            carry += (p1 < 0) ? 0 : (num1.charAt(p1) - '0');
            carry += (p2 < 0) ? 0 : (num2.charAt(p2) - '0');

            sb.append((carry%10));
            carry /= 10;
            p1--;
            p2--;
        }

        return sb.reverse().toString();
    }
}
