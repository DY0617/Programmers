import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] stk = {};
        Stack<Integer> stack=new Stack<>();
        int i=0;
        
        while(i<arr.length){
            if(stack.isEmpty()){
                stack.add(arr[i++]);
            }
            else if(stack.peek()<arr[i]){
                stack.add(arr[i++]);
            }
            else if(stack.peek()>=arr[i])
                stack.pop();
            
        }
        
        stk=new int[stack.size()];
        
        for(int a=stk.length-1;a>=0;a--){
            stk[a]=stack.pop();
        }
        
        return stk;
    }
}