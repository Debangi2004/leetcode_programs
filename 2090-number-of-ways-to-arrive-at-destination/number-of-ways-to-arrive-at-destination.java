class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)1e9 + 7;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] t = new long[n]; // ✅ long to store large time values
        Arrays.fill(t, Long.MAX_VALUE);
        t[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0}); // [time, node]

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long timeTaken = curr[0];
            int src = (int) curr[1];

            if (timeTaken > t[src]) continue;

            for (int[] neighbor : adj.get(src)) {
                int next = neighbor[0];
                int wt = neighbor[1];
                long totalTime = timeTaken + wt;

                if (totalTime < t[next]) {
                    t[next] = totalTime;
                    ways[next] = ways[src];
                    pq.offer(new long[]{t[next], next});
                } else if (totalTime == t[next]) {
                    ways[next] = (int)((ways[next] + 0L + ways[src]) % mod);
                }
            }
        }

        return ways[n - 1];
    }
}
