class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        // Step 1: Create reversed adjacency list
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Step 2: Reverse the edges and compute indegree
        for (int i = 0; i < V; i++) {
            for (int it : graph[i]) {
                adjRev.get(it).add(i);  // Reverse the edge
                indegree[i]++;          // Original node i has an outgoing edge
            }
        }

        // Step 3: Kahn’s Algorithm (topo sort)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
