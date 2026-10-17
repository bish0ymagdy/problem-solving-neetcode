class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];

                // Ignore empty cells represented by '.'
                if (number != '.') {
                    // Create unique identifiers for row, column, and 3x3 sub-box
                    String rowKey = "row " + i + ": " + number;
                    String colKey = "col " + j + ": " + number;
                    String boxKey = "box " + (i / 3) + "," + (j / 3) + ": " + number;

                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey)) {
                        return false;
                    }

                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(boxKey);
                }
            }
        }

        return true;
    }
}
