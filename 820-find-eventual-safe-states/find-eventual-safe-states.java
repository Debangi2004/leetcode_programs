import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjRev = new ArrayList<>();
        
        // Step 1: Create reverse graph
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int neighbor : graph[i]) {
                adjRev.get(neighbor).add(i); // reverse the edge
                indegree[i]++;               // count outgoing edges in original graph
            }
        }

        // Step 2: Kahn’s algorithm
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i); // terminal nodes
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int neighbor : adjRev.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        Collections.sort(safeNodes); // sort the safe nodes
        return safeNodes;
    }
}
