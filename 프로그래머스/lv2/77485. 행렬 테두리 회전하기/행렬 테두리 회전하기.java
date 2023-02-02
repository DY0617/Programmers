import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr= new int[rows][columns];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=i*columns+j+1;
            }
        }
        
        
        int idx=0;
        
        for(int[] q:queries){
            
            int min=Integer.MAX_VALUE;
            int x1=q[0]-1;
            int y1=q[1]-1;
            int x2=q[2]-1;
            int y2=q[3]-1;
            
            int temp=arr[x1][y1];
            int save;
            
            for(int i=y1+1;i<=y2;i++){
                min=Math.min(min,temp);
                save=arr[x1][i];
                arr[x1][i]=temp;
                temp=save;
            }
            for(int i=x1+1;i<=x2;i++){
                min=Math.min(min,temp);
                save=arr[i][y2];
                arr[i][y2]=temp;
                temp=save;
            }
            for(int i=y2-1;i>=y1;i--){
                min=Math.min(min,temp);
                save=arr[x2][i];
                arr[x2][i]=temp;
                temp=save;
            }
            for(int i=x2-1;i>=x1;i--){
                min=Math.min(min,temp);
                save=arr[i][y1];
                arr[i][y1]=temp;
                temp=save;
            }
            answer[idx]=min;
            idx++;
            
            
            
        }
        

        
        
        return answer;
    }
}