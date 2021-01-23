class Solution {

    //CAN BE OPTIMIZED SO THAT THE KEY IS A STRING INSTEAD OF HASHMAP<INTEGER, INTEGER>
    //basically just need to use an int[] array for count like I originally had, and then convert that to #x#y#z... etc for each letter count
    public List<List<String>> groupAnagrams(String[] strs) {
        //generate hashset as keys for each string (their character counts)
        //add to hashmap (key is hashset, value is list of strings)
        //add each list of strings to the list

        HashMap<HashMap<Integer, Integer>, List<String>> charCounts = new HashMap<HashMap<Integer, Integer>, List<String>>();

        for(int i = 0; i < strs.length; i++){
            HashMap<Integer, Integer> charCount = new HashMap<Integer, Integer>();
            String s = strs[i];

            for(int j = 0; j < s.length(); j++){
                int index = s.charAt(j) - 'a';
                if(charCount.containsKey(index)){
                    charCount.put(index, charCount.get(index)+1);
                }
                else {
                    charCount.put(index, 1);
                }
            }

            if(charCounts.containsKey(charCount)){
                charCounts.get(charCount).add(s);
            }
            else {
                List<String> newList = new ArrayList<String>();
                newList.add(s);
                charCounts.put(charCount, newList);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for(HashMap<Integer, Integer> i : charCounts.keySet()){
            result.add(charCounts.get(i));
        }
        return result;
    }
}
