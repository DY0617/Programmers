import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer=new int[2];
        StringTokenizer st;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> reversePq=new PriorityQueue<>((o1,o2)->o2-o1);
        
        for(String now:operations){
            st=new StringTokenizer(now);
            String command=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            
            if(command.equals("I")){
                pq.add(num);
                reversePq.add(num);
            }
            if(command.equals("D")){
                if(!pq.isEmpty()){
                    if(num==1){
                        int k=reversePq.poll();
                        pq.remove(k);
                    }
                    else if(num==-1){
                        int k=pq.poll();
                        reversePq.remove(k);
                    }
                }
            }
            
        }
        
        if(!pq.isEmpty()){
            answer[0]=reversePq.peek();
            answer[1]=pq.peek();   
        }

        
        return answer;
    }
}