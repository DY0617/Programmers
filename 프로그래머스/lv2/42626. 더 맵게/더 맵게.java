import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        
        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        
        
        while(pq.peek()<K){
            int now=pq.poll();
            if(pq.isEmpty())
                return -1;
            int next=pq.poll();
            int newS=now+(next*2);
            pq.add(newS);
            answer++;
        }
        
        return answer;
    }
}