class Solution {

    List<String> allCombos = new ArrayList<String>();

    public Character[] getChars(char c){
        switch (c){
            case '2':
                return new Character[]{'a', 'b', 'c'};
            case '3':
                return new Character[]{'d', 'e', 'f'};
            case '4':
                return new Character[]{'g', 'h', 'i'};
            case '5':
                return new Character[]{'j', 'k', 'l'};
            case '6':
                return new Character[]{'m', 'n', 'o'};
            case '7':
                return new Character[]{'p', 'q', 'r', 's'};
            case '8':
                return new Character[]{'t', 'u', 'v'};
            case '9':
                return new Character[]{'w', 'x', 'y', 'z'};
            default:
                return new Character[]{};
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return allCombos;
        }
        processNextDigit(digits, 0, new StringBuilder());
        return allCombos;
    }

    public void processNextDigit(String digits, int index, StringBuilder sb){
        if(index >= digits.length()){
            allCombos.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        Character[] nextChars = getChars(digit);

        for(Character c: nextChars){
            sb.append(c);
            processNextDigit(digits, index+1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
