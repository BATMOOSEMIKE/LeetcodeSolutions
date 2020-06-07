class Solution {
    public static int reverse(int x) {
        boolean isNegative = false;

        if(x>2147483647 || x< -1 * 2147483647){
            return 0;
        }

        int input = x;
        long result = 0;

        if(input<0){
            input = input*-1;
            isNegative = true;
        }

        int digitNum = String.valueOf(input).length();
        int[] digitArray = new int[digitNum];


        while(input >0){
            for(int i = 0; i<digitNum;i++){
                digitArray[i]=input%10;
                input /= 10;
            }
        }

        for(int i = 0; i<digitNum;i++){
            result = result *10 + digitArray[i];
        }
        /*
         if(!(result<2147483647 && result > -2147483647)){
            return 0;
        }
        */

        if(result>2147483647 || result<-1*2147483647){
            return 0;
        }


        if(isNegative) return (int)(result*-1);

        return (int)result;
    }
}
