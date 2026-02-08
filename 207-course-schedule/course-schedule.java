class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0 ; i<numCourses ; i++) adj.add(new ArrayList<>());
        int m = prerequisites.length;
        for(int i =0;i<m;i++) adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        int indegree[]=new int[numCourses];
        for(int i =0;i<numCourses;i++){
            for(int it : adj.get(i)) indegree[it]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            topo.add(curr);
            for(int it : adj.get(curr)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }

        if(topo.size() == numCourses) return true;
        return false;
    }
}