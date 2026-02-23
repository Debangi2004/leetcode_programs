class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                int value = board[r][c];
                if(value == '.') continue;

                int num = value - '1';
                int boxIndex = (r/3)*3 +c/3;
                if(row[r][num] || col[c][num] || box[boxIndex][num]) return false;
                row[r][num] = true;
                col[c][num] = true;
                box[boxIndex][num] = true;
            }
        }

        return true;
    }
}