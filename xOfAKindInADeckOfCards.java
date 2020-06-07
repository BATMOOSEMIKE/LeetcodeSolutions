class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] digitNum = new int[10000];
        for(int i:deck){
            digitNum[i]++;
        }

        int divisor = 0;
        for(int i = 0; i < 10000; i++){
            if(digitNum[i]>0){
                divisor = greatestCommonDivisor(digitNum[i], divisor);
            }
        }

        if(divisor>=2){
            return true;
        }
        return false;


    }

    //Euclidean algorithm
    public int greatestCommonDivisor(int a, int b){
        if(b == 0){
            return a;
        }
        //b is the next a, a%b is b and if it's 0 b will be returned (because a is divisible by b)
        return greatestCommonDivisor(b, a%b);
    }
}
