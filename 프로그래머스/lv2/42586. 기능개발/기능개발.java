import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> q=new LinkedList<>();
        Queue<Integer> ans=new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            
            int now=(int)Math.ceil((100-progresses[i])/(double)speeds[i]);
            
            if(q.isEmpty()){
                q.add(now);
            }
            else if(q.peek()>=now){
                q.add(now);
            }
            else{
                ans.add(q.size());
                q=new LinkedList<>();
                q.add(now);
            }
            
            
            if(!q.isEmpty()){
                if(i==progresses.length-1){
                    ans.add(q.size());
                    q=new LinkedList<>();
                    q.add(now);
                }
            }
                
        }
        
        answer=new int[ans.size()];
        
        for(int i=0;i<answer.length;i++){
            answer[i]=ans.poll();
        }
        
        return answer;
    }
}