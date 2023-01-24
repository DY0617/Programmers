import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        while(true){
            int del=cap;
            int pick=0;
            
            
            for(int i=n-1;i>=0;i--){
                if(deliveries[i]==0&&pickups[i]==0){
                    n--;
                }
                else
                    break;
            }
            
            if(n==0)
                break;
            
            for(int i=n-1;i>=0;i--){
                if(deliveries[i]!=0){
                    if(del-deliveries[i]>=0){
                        del-=deliveries[i];
                        deliveries[i]=0;
                }
                    else{
                        deliveries[i]-=del;
                        break;
                    }
                }
            }
                        
            for(int i=n-1;i>=0;i--){
                if(pickups[i]!=0){
                    if(pick+pickups[i]<=cap){
                        pick+=pickups[i];
                        pickups[i]=0;
                    }
                    else{
                        pickups[i]-=(cap-pick);
                        break;
                    }
                }

            }
            
            
            answer+=n*2;
        }
        
        return answer;
    }
}