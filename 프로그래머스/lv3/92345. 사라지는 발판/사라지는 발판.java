import java.util.*;

class Solution {
    public static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int boardRowLen, boardColLen;
    
    class Result{
        boolean win;
        int count;
        
        public Result(boolean win, int count){
            this.win = win;
            this.count = count;
        }
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        boardRowLen = board.length;
        boardColLen = board[0].length;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1], 0, board).count;
    }
    
    public Result dfs(int x1, int y1, int x2, int y2, int depth, int[][] board){
        
        boolean win = false;
        int minCount = 5*5;
        int maxCount = depth;
        
        if(board[x1][y1] == 1){
            for(int[] tmp : dir){
                int x1Tmp = x1 + tmp[0];
                int y1Tmp = y1 + tmp[1];
                if(isValid(x1Tmp, y1Tmp, board)){
                    board[x1][y1] = 0;

                    Result d = dfs(x2, y2, x1Tmp, y1Tmp, depth+1, board);
                    win |= !d.win;
                    if(!d.win) minCount = Math.min(minCount, d.count);
                    else maxCount = Math.max(maxCount, d.count);

                    board[x1][y1] = 1;
                }
            }
        }
        
        return new Result(win, win ? minCount : maxCount);
    }
    
    public boolean isValid(int x, int y, int[][] board){
        if(x < 0 || x >= boardRowLen || y < 0 || y >= boardColLen || board[x][y] == 0) return false;
        return true;
    }
}