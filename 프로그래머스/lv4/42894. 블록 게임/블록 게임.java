class Solution {
    int[][] board;
    int n;
    int ROW = 201, COLUMN = 202;
    public int solution(int[][] board) {
        int answer = 0;
        this.n = board.length;
        this.board = board;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 0){
                    int direction = checkDirection(i,j);
                    if(direction == COLUMN && checkColumn(i, j)){
                        answer++;
                    }
                    if(direction == ROW && checkRow(i, j)){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
    
    int checkDirection(int i, int j){
        int num = board[i][j];
        if(i-2 >= 0 && board[i-1][j] == num && board[i-2][j] == num)
            return COLUMN;
        if(j+2 < n && board[i][j+1] == num && board[i][j+2] == num)
            return ROW;
        
        else return -1;
    }
    
    boolean checkColumn(int i, int j){
        int num = board[i][j];
        if(j-1 >= 0){
            if(board[i][j-1] == num && board[i-1][j-1] == 0 && board[i-2][j-1] == 0){
                if(checkUpper(i-2, j-1)){
                    board[i][j-1] = 0;
                    cleanColumn(i, j);
                    return true;
                } 
                else return false;
            }
        }
        
        if(j+1 < n){
            if(board[i][j+1] == num && board[i-1][j+1] == 0 && board[i-2][j+1] == 0){
                if(checkUpper(i-2, j+1)){
                    board[i][j+1] = 0;
                    cleanColumn(i, j);
                    return true;
                }
                else return false;
            }
        }
        
        return false;
    }
    
    boolean checkRow(int i, int j){
        int num = board[i][j];
        if(i-1 >= 0){
            if(board[i-1][j] == num && board[i-1][j+1] == 0 && board[i-1][j+2] == 0){
                if(checkUpper(i-1, j+1) && checkUpper(i-1, j+2)){
                    board[i-1][j] = 0;
                    cleanRow(i,j);
                    return true;
                }
            }
            if(board[i-1][j] == 0 && board[i-1][j+1] == num && board[i-1][j+2] == 0){
                if(checkUpper(i-1, j) && checkUpper(i-1, j+2)){
                    board[i-1][j+1] = 0;
                    cleanRow(i,j);
                    return true;
                }
            }
            if(board[i-1][j] == 0 && board[i-1][j+1] == 0 && board[i-1][j+2] == num){
                if(checkUpper(i-1, j) && checkUpper(i-1, j+1)){
                    board[i-1][j+2] = 0;
                    cleanRow(i,j);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean checkUpper(int i, int j){
        for(int k = i; k >= 0; k--){
            if(board[k][j] != 0) return false;
        }
        return true;
    }
    
    void cleanColumn(int i, int j){
        for(int k = 0; k < 3; k++){
            board[i-k][j] = 0;
        }
    }
    
    void cleanRow(int i, int j){
        for(int k = 0; k < 3; k++){
            board[i][j+k] = 0;
        }
    }
}