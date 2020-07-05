//THIS IS A BETTER SOLUTION I FOUND

class Solution {
    public String removeOuterParentheses(String S) {
        if(S == null || S.length() < 1) return S;
        StringBuilder sb = new StringBuilder(""); // for O(1) modification
        int check=0; // to count open and closed paranthesis
		int start=0; // to get the component's starting point
        for(int i=0;i<S.length();i++){
           if(S.charAt(i) == '(') check++; // ++ for open bracket
           else check--; // -- for closed bracket
           if(check == 0){ // this indicates that we got the 1 component of balanced paranthesis
               sb.append(S.substring(start+1,i)); // add the component to the answer string by removing outermost paranthesis
               start = i+1; // change the starting point to find another component
            }
        }
        return sb.toString(); // now convert the stringBuilder object to String object
    }
}
