class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //basically i think we can iterate through every number from 0 to n-1
        //do a dfs on that node, keeping track of who the original node dislikes
        //if we run into a node that the original node dislikes again, then it's impossible.



        //IMPLEMENTATION
        //first we build an adj list
        HashMap<Integer, List<Integer>> adjlist = new HashMap<Integer, List<Integer>>();

        for(int i = 1; i <= N; i++){
            adjlist.put(i, new LinkedList<Integer>());
        }

        for(int i = 0; i < dislikes.length; i++){
            adjlist.get(dislikes[i][0]).add(dislikes[i][1]);
            adjlist.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        //we do dfs on every node (if not already included in another dfs)
        //keep track of "group a" and "group b"
        //if next disliked needs to be group a and its already in group b or vice versa return false
        //otherwise at end of iteration through children, return true


        int[] searched = new int[N+1];
        //dfs needs parent param to ensure no doubling back
        //dfs needs adjlist
        //dfs needs groupa array
        //dfs needs groupb array
        //dfs needs isGroupA boolean
        //dfs needs searched array to prevent duplicate dfs calls
        for(int i = 1; i <= N; i++){
            if(searched[i] == 0){
                if(!dfs(adjlist, i, 0, new int[N+1], new int[N+1], true, searched)){
                    return false;
                }
            }
        }

        return true;

    }


    public boolean dfs(HashMap<Integer, List<Integer>> adj, int n, int parent, int[] groupa, int[] groupb, boolean isA, int[] searched){

        //if we searched n and program still running then no flaw is in the graph containing n
        if(searched[n] == 1){
            return true;
        }
        //if n already belongs to the wrong group
        else if(isA && groupb[n] == 1 || !isA && groupa[n] == 1){
            return false;
        }
        else if(isA && groupa[n] == 1 || !isA && groupb[n] == 1){
            return true;
        }


        if(isA){
            groupa[n] = 1;
        }
        else {
            groupb[n] = 1;
        }

        List<Integer> nextDisliked = adj.get(n);
        for(Integer integer : nextDisliked){
            int i = integer.intValue();
            if(i != parent && searched[i] == 0){
                if(!dfs(adj, i, n, groupa, groupb, !isA, searched)){
                    return false;
                }
            }
        }
        searched[n] = 1;
        return true;
    }

}
