class Solution {
    public int maximum69Number (int num) {
        int[] numArray = new int[String.valueOf(num).length()];

        for(int i = 0; i < numArray.length; i++){
            numArray[i] = num % 10;
            num /= 10;
        }

        //System.out.println(Arrays.toString(numArray));
        for(int i = numArray.length-1; i >= 0; i--){
            if(numArray[i] == 6){
                numArray[i] = 9;
                break;
            }
        }
        //System.out.println(Arrays.toString(numArray));
        int result = 0;

        for(int i = 0; i < numArray.length; i++){
            result += numArray[i] * Math.pow(10, i);
            System.out.println(numArray[i]);
        }

        return result;
    }
}
