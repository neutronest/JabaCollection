public class Solution {
    public int countBattleships(char[][] board) {
        
        int res = 0;
        if (board.length == 0) {
            return 0;
        }
        
        
        int row_num = board.length;
        int col_num = board[0].length;
        
        // init the flag arr
        int[][] board_flag = new int[row_num][col_num];
        for (int i=0; i< row_num; i++) {
            for(int j=0; j< col_num; j++) {
                board_flag[i][j] = 0;
            }
        }
        
        for (int i=0; i< row_num; i++) {
            for (int j=0; j<col_num; j++) {
                // side case check
                if (board[i][j] == '.') {
                    board_flag[i][j] = 1;
                    continue;   
                } // end if
                if (board_flag[i][j]  == 1) {
                    continue;
                }
                
                int left_cur = j+1;
                int down_cur = i+1;
                board_flag[i][j] = 1;
                // left direct check
                while(left_cur < col_num && board[i][left_cur] == 'X' && board_flag[i][left_cur] == 0) {
                    board_flag[i][left_cur] = 1;
                    left_cur += 1;
                }
                while(down_cur < row_num && board[down_cur][j] == 'X' && board_flag[down_cur][j] == 0) {
                    board_flag[down_cur][j] = 1;
                    down_cur += 1;
                }
                res += 1;
            } // end for j
        } // end for i
        return res;
    } // end main
}
