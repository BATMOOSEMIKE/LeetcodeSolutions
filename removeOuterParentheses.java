class Solution {
    public String removeOuterParentheses(String S) {
        Stack<String> stack = new Stack<String>();
        List<String> primitives = new ArrayList<String>();

        String curWord = "";
        String result = "";

        for(int i = 0; i < S.length(); i++) {
            String letter = S.substring(i,i+1);
            curWord += letter;
            //Opening parentheses
            if(letter.equals("(")){
                stack.push(letter);
            }
            //Closing parentheses, closing a full statement
            else if(stack.size() == 1){
                stack.pop();
                primitives.add(curWord);
                curWord = "";
            }
            //Closing parentheses, part of a larger statement
            else {
                stack.pop();
            }
        }

        for(String s: primitives){
            result += s.substring(1,s.length()-1);
        }

        return result;
    }
}
