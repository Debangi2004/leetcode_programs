public class Solution {

int n;
int m;
char[][] g;

public int numIslands(char[][] grid) {
    g = grid;
    int count = 0;
    n = g.length;
    if (n == 0) return 0;
    m = g[0].length;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++)
            if (g[i][j] == '1') {
                DFSMarking(i, j);
                count++;
            }
    }    
    return count;
}

private void DFSMarking(int i, int j) {
    if (i < 0 || j < 0 || i >= n || j >= m || g[i][j] != '1') 
        return;
    g[i][j] = '0';
    DFSMarking(i + 1, j);
    DFSMarking(i - 1, j);
    DFSMarking(i, j + 1);
    DFSMarking(i, j - 1);  
}
}