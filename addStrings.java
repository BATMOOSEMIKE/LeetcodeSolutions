class Solution {
  public static String addStrings(String num1, String num2) {
        String result = "";
        int carry = 0;
        String shorter, longer;
        if(num1.length() < num2.length()) {
          shorter = num1;
          longer = num2;
        }
        else {
          shorter = num2;
          longer = num1;
        }

        while(!shorter.equals("")) {
          int sum = Integer.parseInt(String.valueOf(shorter.charAt(shorter.length()-1))) + Integer.parseInt(String.valueOf(longer.charAt(longer.length()-1))) + carry;
          shorter = shorter.substring(0,shorter.length()-1);
          longer = longer.substring(0, longer.length()-1);
          if(sum <= 9) {
            result = Integer.toString(sum) + result;
            carry = 0;
          }
          else {
            carry = sum / 10;
            result = Integer.toString(sum%10) + result;
          }
        }

        if(!longer.equals("")){
          result = addStrings(longer, Integer.toString(carry)) + result;
          carry = 0;
        }
        if (carry != 0) {
          result = Integer.toString(carry) + result;
        }

        return result;

    }
}
