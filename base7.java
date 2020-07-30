//Runtime O(logN) where N is the num

class Solution {
    public String convertToBase7(int num) {
        String result = "";
        boolean isNegative = false;
        if(num < 0){
            isNegative = true;
            num = -num;
        }
        if(num == 0){
            return "0";
        }
        int greatestDigit = logSeven(num);
        while(greatestDigit > 0){
            int power = (int) Math.pow(7, greatestDigit-1);
            result = result + num/power;
            num = num % power;
            greatestDigit--;
        }
        if(isNegative){
            return "-" + result;
        }
        return result;
    }

    public int logSeven(int num){
        int count = 0;
        int cur = 1;
        while(num >= cur){
            cur *= 7;
            count++;
        }
        return count;
    }
}
