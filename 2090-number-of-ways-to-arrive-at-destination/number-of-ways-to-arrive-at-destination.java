class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] t = new long[n];
        for(int i =0;i<n;i++)
        {
            t[i]=Long.MAX_VALUE;
        }
        t[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        q.add(new long[]{0, 0}); // [time, node]

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            long timeTaken = curr[0];
            int src = (int) curr[1];

            if (timeTaken > t[src]) continue;

            for (int[] it : adj.get(src)) {
                int adjNode = it[0];
                int tT = it[1];

                if (timeTaken + tT < t[adjNode]) {
                    t[adjNode] = timeTaken + tT;
                    ways[adjNode] = ways[src];
                    q.add(new long[]{t[adjNode], adjNode});
                } else if (timeTaken + tT == t[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[src]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}
