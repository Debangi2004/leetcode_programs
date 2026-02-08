class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights == null || heights.length == 0) return ans;

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i =0 ;i<m;i++){
            dfs(heights,pacific,i,0,m,n);
            dfs(heights,atlantic,i,n-1,m,n);
        }
        for(int j =0 ;j<n;j++){
            dfs(heights,pacific,0,j,m,n);
            dfs(heights,atlantic,m-1,j,m,n);
        }

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]) 
                    ans.add(Arrays.asList(i,j));
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c, int m , int n){
        ocean[r][c]= true;
        int dr[]={1,0,0,-1};
        int dc[]={0,1,-1,0};

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<0 || nc<0 || nr>=m || nc>=n) continue;
            if(ocean[nr][nc]) continue;
            if(heights[nr][nc]<heights[r][c]) continue;

            dfs(heights, ocean, nr, nc, m, n);
        }
    }
}