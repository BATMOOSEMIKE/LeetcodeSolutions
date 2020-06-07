class Solution {
    public boolean isAnagram(String s, String t) {
        ArrayList<Character> firstStringChars = new ArrayList<Character>();
        ArrayList<Character> secondStringChars = new ArrayList<Character>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            firstStringChars.add(s.charAt(i));
        }

        for (int i = 0; i < t.length(); i++) {
            secondStringChars.add(t.charAt(i));
        }

        Collections.sort(firstStringChars);
        Collections.sort(secondStringChars);



        for(int i = 0; i<secondStringChars.size();i++){
            if(firstStringChars.get(i)!=secondStringChars.get(i)){
                return false;
            }
        }

        return true;

    }
}
