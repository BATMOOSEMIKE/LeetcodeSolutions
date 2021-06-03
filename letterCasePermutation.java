class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> acc = new ArrayList<String>();
        String sacc = "";
        branch(s, 0, sacc, acc);
        return acc;
    }

    //this function will add the sacc to acc if index reaches end, otherwises makes recursive calls
    public void branch(String s, int index, String sacc, List<String> acc){
        //if index passes s length then add to acc
        if(index >= s.length()){
            acc.add(sacc);
        }
        //if letter make 2 recursive branches
        else if(Character.isLetter(s.charAt(index))){
            char c = s.charAt(index);
            String sacc1 = sacc + Character.toLowerCase(c);
            String sacc2 = sacc + Character.toUpperCase(c);
            branch(s, index+1, sacc1, acc);
            branch(s, index+1, sacc2, acc);
        }
        //otherwise keep going after updating sacc
        else {
            char c = s.charAt(index);
            sacc += c;
            branch(s, index+1, sacc, acc);
        }
    }
}
