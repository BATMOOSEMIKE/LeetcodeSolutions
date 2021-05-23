//Runtime O(N) where N is the length of s
//Goes through each letter, figures out what row it should go in by keeping
//track of direction and curRow
//Ugly handling of numRows == 1 edge case

class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();

        int rowCount = Math.min(numRows, s.length());

        for(int i = 0; i < rowCount; i++){
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        //1 is up 0 is down
        int direction = 0;

        for(int i = 0; i < s.length(); i++){
            rows.get(curRow).append(s.charAt(i));
            if(curRow == 0 && direction == 1){
                direction = 0;
            }
            else if(curRow == rowCount-1 && direction == 0){
                direction = 1;
            }

            if(direction == 0){
                curRow++;
            }
            else{
                curRow--;
            }
        }

        StringBuilder result = new StringBuilder();

        for(StringBuilder sb: rows){
            result.append(sb);
        }

        return result.toString();


    }
}
