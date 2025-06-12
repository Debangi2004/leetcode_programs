class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();  
        int n = grid.length; 
        int m = grid[0].length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0 || n==0) {
            return -1;
        }


        if (n == 1 && grid[0][0] == 0) {
            return 1; 
        }

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0. 
        int[][] dist = new int[n][m]; 
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = 1; 
        q.add(new int[]{1, 0, 0}); 

        while(!q.isEmpty()) {
            int node[] = q.poll();
            int dis = node[0];
            int row = node[1];
            int col = node[2];            
            for(int r = -1;r<=1;r++) {
                for(int c=-1;c<=1;c++)
                {
                    int nr = row + r;
                    int nc = col + c; 
                    
                    // Checking the validity of the cell and updating if dist is shorter.
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] ==   0 && dis+1 < dist[nr][nc]) {
                        dist[nr][nc] = 1 + dis; 

                        // Return the distance until the point when
                        // we encounter the destination cell.
                        if(nr == n - 1 && nc == m - 1){
                            return dis + 1;
                        }

                        q.add(new int[]{1+dis, nr, nc}); 
                    }
                }
            }
        }
        // If no path is found from source to destination.
        return -1; 
    }
}