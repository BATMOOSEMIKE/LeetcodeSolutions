//Runtime O(N)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> ocurrences = new ArrayList<String>();

        String[] textArray = text.split(" ");

        if(textArray.length >= 3){
            for(int i = 0; i < textArray.length-2; i++){
                if(textArray[i].equals(first) && textArray[i+1].equals(second)) {
                    ocurrences.add(textArray[i+2]);
                }
            }
        }

        String[] ocurrenceArray = new String[ocurrences.size()];
        ocurrenceArray = ocurrences.toArray(ocurrenceArray);
        return ocurrenceArray;
    }
}
