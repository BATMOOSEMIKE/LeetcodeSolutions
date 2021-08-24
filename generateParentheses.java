//This is a backtracking solution, but not the best because of the need to convert back and forth from
//set to arraylist etc
//Better would be to just treat adding '(' and adding ')' as the two choices with counter for open and close
//to see if adding ) is an option

class Solution {
    Set<String> sAcc = new HashSet<String>();

    public List<String> generateParenthesis(int n) {
        //at any step, we can either put down () or open a parentheses that must be closed later
        //we can also close any existing opened parentheses

        chooseAction(n, new StringBuilder(), 0);
        return new ArrayList<String>(sAcc);
    }

    public void chooseAction(int n, StringBuilder acc, int open){
        //done and no more closing needed
        if(n == 0 && open == 0){
            sAcc.add(new StringBuilder(acc).toString());
        }
        //done but gotta close
        else if(n == 0){
            acc.append(')');
            chooseAction(n, acc, open-1);
            acc.setLength(acc.length()-1);
        }
        //still have choices
        else {
            //choice 1: just add a ()
            acc.append("()");
            chooseAction(n-1, acc, open);
            acc.setLength(acc.length()-2);

            //choice 2: open a new (
            acc.append("(");
            chooseAction(n-1, acc, open+1);
            acc.setLength(acc.length()-1);

            //choice 3: close a pre-existing open (
            if(open > 0){
                acc.append(")");
                chooseAction(n, acc, open-1);
                acc.setLength(acc.length()-1);
            }
        }
    }
}
