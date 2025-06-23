class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countOranges=0;

        if(n==0||m==0)
        {
            return -1;
        }
        
        Queue<int[]> q =new LinkedList<>();
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] != 0)
                {
                    countOranges++;
                    if(grid[i][j] == 2)
                    {
                        q.add(new int[]{i,j});
                    }
                }
            }
        }
        if(countOranges == 0)
        {
            return 0;
        }
        int countMin=0;
        int count =0;
        int dr[]={0,1,-1,0};
        int dc[]={1,0,0,-1};
        while(!q.isEmpty())
        {
            int s = q.size();
            count=count+s;
            for(int i =0;i<s;i++)
            {
                int point[] = q.poll();
                int row=point[0];
                int col=point[1];
                for(int j=0;j<4;j++)
                {
                    int nr = row+dr[j];
                    int nc = col+dc[j];

                    if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]==2 || grid[nr][nc]==0)
                    {
                        continue;
                    }
                    grid[nr][nc]=2;
                    q.add(new int[]{nr,nc});
                }
            }
            if(q.size()!=0)
            {
                countMin++;
            }
        }
        return countOranges==count?countMin:-1;
    }
}