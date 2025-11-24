class Solution {
    private boolean checkBox(char[][] board, int sr, int sc) {
        Set<Character> seen = new HashSet<>();
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (seen.contains(ch)) return false;
                seen.add(ch);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];
                if (ch == '.') continue;
                if (seen.contains(ch)) return false;
                seen.add(ch);
            }
        }
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col]; // fixed index order
                if (ch == '.') continue;
                if (seen.contains(ch)) return false;
                seen.add(ch);
            }
        }
        for (int sr = 0; sr < 9; sr += 3) {
            for (int sc = 0; sc < 9; sc += 3) {
                if (!checkBox(board, sr, sc)) return false;
            }
        }
        return true;
    }
}
