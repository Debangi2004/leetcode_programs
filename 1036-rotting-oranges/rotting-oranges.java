class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid==null) return 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int countFresh=0;
        int countMin=0;
        int count=0;

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    countFresh++;
                }
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(countFresh == 0) return 0;

        
        while(!q.isEmpty()){
            int size=q.size();
            //count+=size;
            for(int i=0;i<size;i++){
                int point[]=q.poll();
                int row=point[0];
                int col=point[1];
                int dr[]={1,0,-1,0};
                int dc[]={0,1,0,-1};
                for(int j=0;j<4;j++){
                    int nr=row+dr[j];
                    int nc=col+dc[j];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        q.add(new int[]{nr,nc});
                        count++;
                    }
                }
            }
            countMin++;
        }
        return countFresh==count?countMin-1:-1;
    }
}