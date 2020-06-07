class Solution {
    public int numJewelsInStones(String J, String S) {
        int JLength = J.length();
        int SLength = S.length();

        String[] jewels = new String[JLength];
        String[] stones = new String[SLength];

        for(int i = 0; i<JLength;i++){
            jewels[i] = Character.toString(J.charAt(i));
        }

        int counter = 0;

        for(int i = 0; i<SLength; i++){
            stones[i] = Character.toString(S.charAt(i));
        }

        for(int i = 0; i<JLength;i++){
            for(int j = 0; j<SLength;j++){
                if(jewels[i].equals(stones[j])){
                    counter++;
                }
            }
        }

        return counter;
    }
}
