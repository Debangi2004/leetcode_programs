class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i<m;i++){
            if(grid[i][0] == 1) dfs(grid,i,0);
            if(grid[i][n-1] == 1) dfs(grid,i,n-1);
        }
        for(int j =0;j<n;j++){
            if(grid[0][j] == 1) dfs(grid,0,j);
            if(grid[m-1][j] == 1) dfs(grid,m-1,j);
        }

        int count = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int grid[][], int r, int c)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0) return;

        grid[r][c]=0;
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}