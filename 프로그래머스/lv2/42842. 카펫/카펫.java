import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1;i*i<=yellow;i++){
            if(yellow%i==0){
                int a=i;
                int b=yellow/a;
                if(a*2+b*2+4==brown){
                    if(a>=b){                       
                        answer[0]=a+2;
                        answer[1]=b+2;
                    }
                    else{
                        answer[0]=b+2;
                        answer[1]=a+2;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
    
    
}