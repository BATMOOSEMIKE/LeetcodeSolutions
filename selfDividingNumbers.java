//O(N*LogN) where N is right because the number of digits of right is proportional to LogN

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers = new ArrayList<Integer>();

        for(int i = left; i <= right; i++){
            if(isSelfDividing(i)){
                numbers.add(i);
            }
        }

        return numbers;
    }

    public boolean isSelfDividing(int i){
        int num = i;
        while(i > 0){
            int curDigit = i%10;
            if(curDigit == 0 || num % curDigit != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
