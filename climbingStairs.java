class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(1, 1);
        map.put(2, 2);

        return climbMemo(n, map);
    }

    public int climbMemo(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        else {
            map.put(n, climbMemo(n-1, map) + climbMemo(n-2, map));
            return map.get(n);
        }
    }
}
