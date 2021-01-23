class Solution {


    public List<String> letterCombinations(String digits) {
        List<String> letterCombos = new ArrayList<String>();

        for(int i = 0; i < digits.length(); i++){
            List<String> tempCombos = new ArrayList<String>();
            String[] curPossibilities = getChars(digits.charAt(i));

            if(letterCombos.size() == 0){
                for(int j = 0; j < curPossibilities.length; j++){
                    tempCombos.add(curPossibilities[j]);
                }
            }
            else {
                for(String s: letterCombos){
                    for(int j = 0; j < curPossibilities.length; j++){
                        tempCombos.add(s + curPossibilities[j]);
                    }
                }
            }

            letterCombos = tempCombos;
        }

        return letterCombos;
    }

    public String[] getChars(char c){
        switch (c){
            case '2':
                return new String[]{"a", "b", "c"};
            case '3':
                return new String[]{"d", "e", "f"};
            case '4':
                return new String[]{"g", "h", "i"};
            case '5':
                return new String[]{"j", "k", "l"};
            case '6':
                return new String[]{"m", "n", "o"};
            case '7':
                return new String[]{"p", "q", "r", "s"};
            case '8':
                return new String[]{"t", "u", "v"};
            case '9':
                return new String[]{"w", "x", "y", "z"};
            default:
                return new String[]{"69"};
        }

    }

}
