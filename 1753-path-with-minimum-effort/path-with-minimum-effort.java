class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);


        int[][] dist = new int[n][m]; 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0]=1;
        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int point[]=pq.poll();
            int dis=point[0];
            int row = point[1];
            int col = point[2];

            int dx[] = {-1, 0, 0, 1};
            int dy[] = {0, -1, 1, 0};

            if(row == n-1 && col == m-1)
                {
                    return dis; 
                }

            for(int i=0;i<4;i++)
            {
                int nr=row+dx[i];
                int nc=col+dy[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m)
                {
                    int maxEffort=Math.max(Math.abs(heights[row][col] - heights[nr][nc]), dis);
                    if(maxEffort < dist[nr][nc]) {
                        dist[nr][nc] = maxEffort; 
                        pq.add(new int[]{maxEffort, nr, nc}); 
                    }
                }
            }
        }
        return 0;
    }
}