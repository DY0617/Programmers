import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] board=new String[n][n];
        
        for(int i=0;i<n;i++){
            String now=Integer.toBinaryString(arr1[i]);
            String now2=Integer.toBinaryString(arr2[i]);
            
            
            
            while(now.length()!=n){
                now="0"+now;
            }
            while(now2.length()!=n){
                now2="0"+now2;
            }

            for(int j=0;j<now.length();j++){
                if(now.charAt(j)=='1'||now2.charAt(j)=='1'){
                    board[i][j]="#";
                }
                else
                    board[i][j]=" ";
            }
        }
        
        for(int i=0;i<board.length;i++){
            String now="";
            for(int j=0;j<board[0].length;j++){
                now+=board[i][j];
            }
            answer[i]=now;
        }
        
        return answer;    }
}