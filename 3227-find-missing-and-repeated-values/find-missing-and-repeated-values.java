class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int  n = grid.length;
        int  m = grid[0].length;
        long num = (long) (n*m);

        long s1 = (num*(num+1))/2;
        long s2 = (num*(num+1)*(2*num + 1))/6;

        long sum1 = 0, sum2 = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                sum1 = (long) grid[i][j] + sum1;
                sum2 = (long) (grid[i][j]*grid[i][j]) + sum2;
            }
        }

        long val1 = sum1 - s1;
        long val2 = sum2 - s2;

        val2 = val2/val1;
        
        int x = (int) (val1 + val2)/2;
        int y = (int) (x - val1);

        return new int[]{x,y};

    }
}