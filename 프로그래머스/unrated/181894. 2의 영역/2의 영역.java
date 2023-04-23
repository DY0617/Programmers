import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        int start=0;
        int end=arr.length-1;
        
        while(true){
            
            if(start==arr.length)
                break;
            
            if(arr[start]==2)
                break;
            
            start++;
        }
        
        while(true){
            if(end==-1)
                break;
            
            if(arr[end]==2)
                break;
            
            end--;
        }
        
        if(end==-1){
            int[] ans=new int[1];
            ans[0]=-1;
            
            return ans;
        }
        
        answer=new int[end-start+1];
                
        
        for(int i=start;i<=end;i++)
            answer[i-start]=arr[i];
        
        return answer;
    }
}