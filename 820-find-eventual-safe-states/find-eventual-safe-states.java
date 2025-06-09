class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Step 1: Reverse the graph and compute indegrees
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u);
                indegree[u]++;
            }
        }

        // Step 2: Add all terminal nodes (indegree 0) to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: BFS - Remove safe nodes from the graph
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : reverseGraph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 4: Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
