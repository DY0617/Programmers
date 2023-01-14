import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = {};
        
        answer=new int[prices.length];
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int next : prices)
            q.add(next);
        
        for(int i=0;i<answer.length-1;i++){
            int count=0;
            int now=q.poll();
            for(int j=i+1;j<answer.length;j++){
                    count++;
                if(now>prices[j])
                    break;
            }
            answer[i]=count;
        }
        
        answer[prices.length-1]=0;
        
        return answer;
    }
}