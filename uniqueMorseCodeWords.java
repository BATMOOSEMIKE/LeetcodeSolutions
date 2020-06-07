class Solution {
    public int uniqueMorseRepresentations(String[] words) {



        String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        String[] morseCodes = new String[words.length];

        for(int i = 0; i<words.length;i++){
            String currentWord = words[i];
            String morseVersion = "";
            for(int j = 0; j<currentWord.length();j++){
                morseVersion += alphabet[((int)currentWord.charAt(j)) - 97];
            }

            morseCodes[i] = morseVersion;
        }


        List<String> list = Arrays.asList(morseCodes);

        Set<String> set = new LinkedHashSet<String>(list);

        int counter = 0;

        for(String uniqueCode : set){
            counter++;
        }

        return counter;
    }
}
