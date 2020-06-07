class Solution {
    public boolean buddyStrings(String A, String B) {
        int diffCounter = 0;
        int indexOne = 0;
        int indexTwo = 0;
        int sameLetterCount = 0;

        int[] Aletters = new int[26];
        int[] Bletters = new int[26];

         if(A.length()!=B.length()){
            return false;
        }

        for(int i = 0; i<A.length();i++){
            Aletters[(int)A.charAt(i)-97] += 1;
        }

        for(int i = 0; i<B.length();i++){
            Bletters[(int)B.charAt(i)-97] += 1;
        }





        for(int i = 0; i<A.length();i++){
            if(A.charAt(i) != B.charAt(i)){
                if(diffCounter == 0){
                    indexOne = i;
                }
                else if (diffCounter == 1){
                    indexTwo = i;
                }
                diffCounter++;
            }
        }


        if(diffCounter == 0){
            for(int i = 0; i<26;i++){
                if(Aletters[i]>=2 && Aletters[i]==Bletters[i]){
                    return true;
                }
            }
        }


        if(diffCounter != 2){
            return false;
        }

        else if(A.charAt(indexOne)==B.charAt(indexTwo) && A.charAt(indexTwo)==B.charAt(indexOne)){
            return true;
        }

        return false;

    }
}
