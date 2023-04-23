import java.util.*;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int plus=common[1]-common[0];
        
        if(common[0]==0){
            return common[common.length-1]+plus;
        }
        
        
        int mul=common[1]/common[0];
        
        boolean p=true;
        boolean m=true;
        
        for(int i=1;i<common.length-1;i++){
            
            if(common[i]==0){
                m=false;
                break;
            }
            
            if(common[i+1]-common[i]!=plus)
                p=false;
            if(common[i+1]/common[i]!=mul)
                m=false;
            
            if(!(p&&m)){
                break;
            }
        }
        
        if(p){
            answer=common[common.length-1]+plus;
        }
        else
            answer=common[common.length-1]*mul;
        
        return answer;
    }
}