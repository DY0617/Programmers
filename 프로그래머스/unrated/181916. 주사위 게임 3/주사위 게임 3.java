import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int[] dice=new int[7];
        
        int max=0;
        int min=4;
        
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        for(int i=1;i<dice.length;i++){
            max=Math.max(dice[i],max);
            if(dice[i]!=0)
                min=Math.min(min,dice[i]);
        }
        
        System.out.println(max);
        
        if(max==4){
            for(int i=1;i<dice.length;i++){
                if(dice[i]==4)
                    return i*1111;
            }
        }
        
        if(max==3){
            int p=0;
            int q=0;
            for(int i=1;i<dice.length;i++){
                if(dice[i]==3)
                    p=i;
                if(dice[i]==1)
                    q=i;
            }
            
            return (int)Math.pow(10*p+q,2);
        }
        
        if(max==2){
            int p=0;
            int q=0;
            if(min==2){
                for(int i=1;i<dice.length;i++){
                    if(dice[i]==2){
                        if(p==0){
                            p=i;
                        }
                        else
                            q=i;
                    }
                }
                return (p+q)*Math.abs(p-q);
            }
            if(min==1){
                int r=0;
                for(int i=1;i<dice.length;i++){
                    if(dice[i]==1){
                        if(q==0){
                            q=i;
                        }
                        else
                            r=i;
                    }
                }
                return q*r;
            }
        }
        
        else{
            for(int i=1;i<dice.length;i++){
                if(dice[i]==1)
                    return i;
            }
        }
        
        return answer;
    }
}