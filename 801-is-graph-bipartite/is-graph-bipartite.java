class Solution {
    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, color, graph)) return false;
            } else if (color[neighbor] == col) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // handle disconnected graphs
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) return false;
            }
        }

        return true;
    }
}
