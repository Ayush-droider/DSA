class Solution {
    public void reverse(int[] row, int i, int j) {
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] row : matrix) {
            reverse(row, 0, row.length - 1);
        }
    }
}
