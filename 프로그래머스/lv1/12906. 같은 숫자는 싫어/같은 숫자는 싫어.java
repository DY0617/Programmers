import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack=new Stack<>();
        
        stack.push(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=stack.peek()){
                stack.push(arr[i]);
            }
        }
        
        int size=stack.size();
        answer=new int[size];
        
        
        while(!stack.isEmpty()){
            int a=stack.pop();
            answer[size-1]=a;
            size--;
        }
        


        return answer;
    }
}