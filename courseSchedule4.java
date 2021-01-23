class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> queryAnswers = new ArrayList<Boolean>();

        //if(isPrereq[a][b] == 1) then a is a prereq of b
        int[][] isPrereq = new int[n][n];
        HashMap<Integer, List<Integer>> adjlist = new HashMap<Integer, List<Integer>>();


        //first we populate adjlist
        for(int i = 0; i < prerequisites.length; i++){
            int prereq = prerequisites[i][0];
            int nextCourse = prerequisites[i][1];
            if(adjlist.containsKey(prereq)){
                adjlist.get(prereq).add(nextCourse);
            }
            else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(nextCourse);
                adjlist.put(prereq, l);
            }
        }

        //now we populate isPrereq via bfs
        for(int i = 0; i < n; i++){
            if(adjlist.containsKey(i)){
                populate(i, adjlist, isPrereq, n);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(isPrereq[i][j]);
            }
            System.out.println();

        }

        //now check each query
        for(int i = 0; i < queries.length; i++){
            queryAnswers.add(isPrereq[queries[i][0]][queries[i][1]] == 1);
        }

        return queryAnswers;
    }

    //bfs on course using adjlist and visited, to populate isPrereq
    public void populate(int origin, HashMap<Integer, List<Integer>> adjlist, int[][] isPrereq, int n){
        Queue<Integer> q = new LinkedList();
        q.offer(origin);

        int[] visited = new int[n];

        while(q.size() > 0){
            int root = q.poll();
            isPrereq[origin][root] = 1;
            //check if root is a prerequisite for something
            if(visited[root] == 0 && adjlist.containsKey(root)){
                List<Integer> nextCourseList = adjlist.get(root);
                for(int i = 0; i < nextCourseList.size(); i++){
                    q.offer(nextCourseList.get(i));
                }
            }
            visited[root] = 1;
        }

    }

}
