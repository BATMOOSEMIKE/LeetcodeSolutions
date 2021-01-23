class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] curChain = new int[numCourses];

        //iterate through every edge
        for(int i = 0; i < prerequisites.length; i++){
            int courseNum = prerequisites[i][0];
            //check if the edge is not yet visited
            if(visited[courseNum] == 0){
                boolean cycleDetect = trace(prerequisites, visited, curChain, courseNum);
                if(cycleDetect){
                    return false;
                }
            }
        }

        return true;
    }

    //try to detect cycle
    public boolean trace(int[][] edges, int[] visited, int[] curChain, int courseNum){
        //if course num has already been traced then there is no cycle
        if(visited[courseNum] == 1){
            return false;
        }
        //if course num is on the current chain of visitations then there is a cycle
        else if(curChain[courseNum] == 1){
            return true;
        }
        //otherwise we don't know yet, so populate curChain and keep going
        else {
            curChain[courseNum] = 1;
            for(int i = 0; i < edges.length; i++){
                if(edges[i][1] == courseNum){
                    if(trace(edges, visited, curChain, edges[i][0])){
                        return true;
                    }
                }
            }
            curChain[courseNum] = 0;
            visited[courseNum] = 1;
        }

        //should never get here
        return false;
    }
}
