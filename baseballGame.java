//O(N^2) where N is the length of ops

class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> prevRounds = new ArrayList<Integer>();
        for(int i = 0; i < ops.length; i++) {
            String cur = ops[i];
            if(cur.equals("+")){
                sum += (prevRounds.get(prevRounds.size()-1) + prevRounds.get(prevRounds.size()-2));
                prevRounds.add(prevRounds.get(prevRounds.size()-1) + prevRounds.get(prevRounds.size()-2));
            }
            else if(cur.equals("D")) {
                sum += 2*prevRounds.get(prevRounds.size()-1);
                prevRounds.add(2*prevRounds.get(prevRounds.size()-1));
            }
            else if(cur.equals("C")){
                sum -= prevRounds.get(prevRounds.size()-1);
                prevRounds.remove(prevRounds.size()-1);
            }
            else {
                sum += Integer.valueOf(cur);
                prevRounds.add(Integer.valueOf(cur));
            }
        }

        return sum;
    }
}
