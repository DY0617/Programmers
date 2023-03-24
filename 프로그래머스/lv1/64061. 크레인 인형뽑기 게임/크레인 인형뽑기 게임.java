import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack=new Stack<>();
        
        for(int move:moves){
            move--;
            int now=0;
            for(int i=0;i<board[0].length;i++){
                if(board[i][move]!=0){
                    now=board[i][move];
                    board[i][move]=0;
                    break;
                }
            }
            
            if(now==0)
                continue;
            
            if(stack.isEmpty()){
                stack.add(now);
            }
            else if(stack.peek()==now){
                stack.pop();
                answer=answer+2;
            }
            else{
                stack.add(now);
            }
        }
        
        return answer;
    }
}