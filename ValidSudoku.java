// TimeComplexity: O(1) since board is of fixed length. If we generalize to n, it would be O(N^2)
// SpaceComplexity: O(1). Since the board is of fixed length.

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        Set<Character>[] rows = new HashSet[m];
        Set<Character>[] cols = new HashSet[m];
        Set<Character>[] boxes = new HashSet[m];

        for(int i = 0; i < m; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                char val = board[r][c];

                if(val == '.'){
                    continue;
                }

                // check row
                if(rows[r].contains(val)){
                    return false;
                }
                rows[r].add(val);

                // check col
                if(cols[c].contains(val)){
                    return false;
                }
                cols[c].add(val);

                // check boxes
                int idx = (r/3*3) + c/3;
                if(boxes[idx].contains(val)){
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
