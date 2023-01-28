import java.util.*;

class Solution {
    
    static Queue<Integer> q1=new LinkedList<>();
    static Queue<Integer> q2=new LinkedList<>();
    
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        long total1=0;
        long total2=0;
        
        for(int i=0;i<queue1.length;i++){
            total1+=queue1[i];
            total2+=queue2[i];
        }
        
        long half=(total1+total2)/2;
        
        while(true){
            if(queue1.length*4<answer)
                return -1;
            
            if(total1==total2){
                break;
            }
            else if(total1>total2){
                int now=q1.poll();
                total1-=now;
                total2+=now;
                q2.add(now);
            }
            else{
                int now=q2.poll();
                total1+=now;
                total2-=now;
                q1.add(now);
            }
            
            
            answer++;
        }
        
        return answer;
    }
}