import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String start="{[(";
        
        Map<Character,Character> pair=new HashMap<>();
        
        pair.put('{','}');
        pair.put('[',']');
        pair.put('(',')');
        
        for(int i=0;i<s.length();i++){
            Stack<Character> stack=new Stack<>();
            
            boolean isTrue=true;
            
            for(int j=0;j<s.length();j++){
                
                char now=s.charAt(j);
                
                if(start.contains(String.valueOf(now))){
                    stack.push(now);
                }
                else if(!stack.isEmpty()){
                    if(now==pair.get(stack.peek())){
                        stack.pop();
                    }
                    else{
                    isTrue=false;
                    break;
                }
                }
                else{
                    isTrue=false;
                    break;
                }
                    

                
            }
            
            if(isTrue){
                if(stack.isEmpty())
                    answer++;
            }
                
            
            s=s.substring(1,s.length())+s.substring(0,1);
            
        }
        
        return answer;
    }
}