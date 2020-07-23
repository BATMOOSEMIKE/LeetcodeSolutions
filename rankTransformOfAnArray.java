class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        int count = 1;

        for(int i = 0; i < arr2.length; i++) {
            if(!rankMap.containsKey(arr2[i])) {
                rankMap.put(arr2[i], count);
                count++;
            }
        }

        int[] answer = new int[arr.length];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = rankMap.get(arr[i]);
        }

        return answer;
    }

}
