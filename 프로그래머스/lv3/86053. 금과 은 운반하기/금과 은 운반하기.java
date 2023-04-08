import java.util.*;

class Solution {
    
    int gGoal,sGoal,size;
    
    int[] gold,silver,capacity,time;
    
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        gGoal=a;
        sGoal=b;
        size=g.length;
        
        gold=g;
        silver=s;
        capacity=w;
        time=t;
        
        long left=0L;
        long right=400000000000000L;
        
        while(left<right){
            long mid=(long)((left+right)/2);
            
            long nowTotal=0L;
            long gTotal=0L;
            long sTotal=0L;
            
            for(int i=0;i<size;i++){
                
                long cnt = mid / (2L * t[i]);
                if (mid % (2L * t[i]) >= t[i])
                    cnt++;
                
                long canMove= Math.min(cnt*capacity[i],gold[i]+silver[i]);
                
                nowTotal+=canMove;
                gTotal+=Math.min(canMove,gold[i]);
                sTotal+=Math.min(canMove,silver[i]);
            }
            
            if(nowTotal>=gGoal+sGoal && gTotal>=gGoal &&sTotal>=sGoal){
                right=mid;
            }
            else
                left=mid+1;
        }
        
        answer=left;
        
        return answer;
    }
}