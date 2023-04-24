import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int idx=0;
        
        Stack<Integer> stack=new Stack<>();
        
        while(idx<arr.length){
            if(stack.isEmpty())
                stack.push(arr[idx++]);
            else if(stack.peek()==arr[idx]){
                stack.pop();
                idx++;
            }
            else{
                stack.push(arr[idx++]);
            }
        }
        
        
        //System.out.println(stack.size());
        
        if(stack.size()==0){
            answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        
        answer=new int[stack.size()];
        
        for(int i=answer.length-1;i>=0;i--){
            answer[i]=stack.pop();
        }
        
        return answer;
    }
}