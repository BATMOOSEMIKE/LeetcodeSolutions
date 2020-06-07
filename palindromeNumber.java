class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int digitNum = String.valueOf(x).length();
        int[] digitArray = new int[digitNum];

        for(int i = 0; i<digitNum && x>0;i++){
            digitArray[i]=x%10;
            x /= 10;

        }

        for(int i = 0; i<(digitNum/2); i++){
            if(digitArray[i] != digitArray[digitNum-i-1]){
                return false;
            }
        }

        return true;


    }
}
