class Solution {
    public int numRabbits(int[] answers) {
        int[] hashTable = new int[1000];

        //populate our hash table
        for(int i = 0; i < answers.length; i++){
            int answer = answers[i];
            hashTable[answer] = hashTable[answer]+1;
        }

        int minSum = 0;

        for(int i = 0; i < 1000; i++){
            //formula is ceiling(hashTable[i]/(i+1))*(i+1) summed
            int denominator = i+1;
            int numerator = hashTable[i];
            minSum += ((numerator+i)/denominator)*denominator;
        }

        return minSum;
    }
}
