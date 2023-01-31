import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] prefixSum=new int[board.length][board[0].length];
        
        for(int[] arr:skill){
                int r1=arr[1];
                int c1=arr[2];
                int r2=arr[3];
                int c2=arr[4];
                int degree=arr[5];
            if(arr[0]==1){
                prefixSum[r1][c1]-=degree;
                if(c2+1!=prefixSum[0].length)
                    prefixSum[r1][c2+1]+=degree;
                if(r2+1!=prefixSum.length)
                    prefixSum[r2+1][c1]+=degree;
                if(c2+1!=prefixSum[0].length&&r2+1!=prefixSum.length)
                    prefixSum[r2+1][c2+1]-=degree;
            }
            else{
                prefixSum[r1][c1]+=degree;
                if(c2+1!=prefixSum[0].length)
                    prefixSum[r1][c2+1]-=degree;
                if(r2+1!=prefixSum.length)
                    prefixSum[r2+1][c1]-=degree;
                if(c2+1!=prefixSum[0].length&&r2+1!=prefixSum.length)
                    prefixSum[r2+1][c2+1]+=degree;
            }
            
        }
        
            
        
        
        for(int i=0;i<prefixSum.length;i++){
            for(int j=1;j<prefixSum[0].length;j++){
                prefixSum[i][j]+=prefixSum[i][j-1];
            }
        }
        for(int i=0;i<prefixSum[0].length;i++){
            for(int j=1;j<prefixSum.length;j++){
                prefixSum[j][i]+=prefixSum[j-1][i];
            }
        }
        for(int i=0;i<prefixSum.length;i++){
            for(int j=0;j<prefixSum[0].length;j++){
                board[i][j]+=prefixSum[i][j];

                if(board[i][j]>0)
                    answer++;
            }

        }

        
        
        
        
        return answer;
    }
}