import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int n=board.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    for(int p=i-1;p<=i+1;p++){
                        if(0<=p&&p<n){
                            for(int q=j-1;q<=j+1;q++){
                                if(0<=q&&q<n){
                                    if(board[p][q]!=1)
                                        board[p][q]=2;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //System.out.print(board[i][j]+" ");
                if(board[i][j]==0)
                    answer++;
            }
            //System.out.println();
        }
        
        return answer;
    }
}