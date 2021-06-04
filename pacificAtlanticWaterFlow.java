//Idea is to dfs from the pacific/atlantic coords instead of checking all coordinates
//O(m*n)

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] checkedFromPacific = new boolean[heights.length][heights[0].length];
        boolean[][] checkedFromAtlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        //go from each pacific element, do a dfs
        for(int i = 0; i < heights.length; i++){
            dfs(heights, i, 0, checkedFromPacific, Integer.MIN_VALUE);
        }
        for(int i = 0; i < heights[0].length; i++){
            dfs(heights, 0, i, checkedFromPacific, Integer.MIN_VALUE);
        }
        //go from each atlantic element, do a dfs
        for(int i = 0; i < heights.length; i++){
            dfs(heights, i, heights[0].length-1, checkedFromAtlantic, Integer.MIN_VALUE);
        }
        for(int i = 0; i < heights[0].length; i++){
            dfs(heights, heights.length-1, i, checkedFromAtlantic, Integer.MIN_VALUE);
        }
        //keep track of checked from each side
        //iterate through all coords in heights and store the ones that are true for both sides
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(checkedFromPacific[i][j] && checkedFromAtlantic[i][j]){
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, int row, int col, boolean[][] checked, int prev){
        //In all these cases, we don't need to continue dfs
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length|| checked[row][col] || prev > heights[row][col]){
            return;
        }
        int value = heights[row][col];
        //otherwise update checked
        checked[row][col] = true;
        //and now continue dfs
        dfs(heights, row-1, col, checked, value);
        dfs(heights, row+1, col, checked, value);
        dfs(heights, row, col-1, checked, value);
        dfs(heights, row, col+1, checked, value);

    }
}
