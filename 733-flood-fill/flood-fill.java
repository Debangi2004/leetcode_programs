class Solution {
    public void dfs(int[][] image, int r, int c, int oldColor,int newColor){
        int m = image.length;;
        int n = image[0].length;

        if(r<0 || c<0 || r>=m || c>=n || image[r][c]!=oldColor) return;

        image[r][c] = newColor;
        dfs(image, r+1, c, oldColor, newColor);
        dfs(image, r-1, c, oldColor, newColor);
        dfs(image, r, c+1, oldColor, newColor);
        dfs(image, r, c-1, oldColor, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor=image[sr][sc];
        if(oldColor == color) return image;
        
        dfs(image, sr, sc, oldColor, color);
        return image;
    }
}