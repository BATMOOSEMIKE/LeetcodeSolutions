//O(N^2) where N is n
//because we must loop up to n and worst case call add each time

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<String>();

        int index = 0;

        for(int i = 1; i <= n; i++){
            if(index >= target.length) {
                break;
            }
            else if(target[index] == i){
                operations.add("Push");
                index++;
            }
            else {
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;
    }
}
