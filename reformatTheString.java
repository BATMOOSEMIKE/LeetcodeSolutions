/*
Runtime analysis: O(length(S)) because you iterate through it once
to populate both stacks then you iterate through each stack so S+S = S
*/
class Solution {
    public String reformat(String s) {
        Stack<Character> letters = new Stack<Character>();
        Stack<Character> numbers = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                numbers.push(s.charAt(i));
            }
            else {
                letters.push(s.charAt(i));
            }
        }

        if(letters.size() > (s.length()+1)/2 || numbers.size() > (s.length()+1)/2) {
            return "";
        }

        String answer = "";
        if(letters.size() > numbers.size()) {
            while(!numbers.empty()) {
                answer += letters.pop();
                answer += numbers.pop();
            }

            while(!letters.empty()) {
                answer += letters.pop();
            }
        }

        else {
            while(!letters.empty()) {
                answer += numbers.pop();
                answer += letters.pop();
            }
            while(!numbers.empty()) {
                answer += numbers.pop();
            }
        }
        return answer;
    }
}
