class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] curChain = new int[numCourses];

        //iterate through every edge
        for(int i = 0; i < prerequisites.length; i++){
            int courseNum = prerequisites[i][0];
            //check if the edge is not yet visited
            if(visited[courseNum] == 0){
                boolean cycleDetect = trace(prerequisites, visited, curChain, courseNum);
                if(cycleDetect){
                    return new int[]{};
                }
            }
        }

        //now we know it's possible

        //create adjacency list
        HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++){
            int prereq = prerequisites[i][1];
            int nextCourse = prerequisites[i][0];

            if(adjList.containsKey(prereq)){
                adjList.get(prereq).add(nextCourse);
            }
            else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(nextCourse);
                adjList.put(prereq, l);
            }
        }


        int[] visited2 = new int[numCourses];
        int[] order = new int[numCourses];

        int index = order.length-1;
        for(int i = 0; i < numCourses; i++){
            if(visited2[i] == 0){
                index = dfs(adjList, visited2, i, order, index);
            }
        }

        return order;

    }

    public int dfs(HashMap<Integer, List<Integer>> graph, int[] visited, int courseNum, int[] order, int index){
        visited[courseNum] = 1;

        if(graph.containsKey(courseNum)){
            List<Integer> connections = graph.get(courseNum);

            for(Integer i: connections){
                if(visited[i.intValue()] == 0){
                    index = dfs(graph, visited, i.intValue(), order, index);
                }
            }
        }

        order[index] = courseNum;
        return index-1;
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
