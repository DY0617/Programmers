import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        class Disk{
            int access, leng;
            Disk(int a,int b){
                access=a;
                leng=b;
            }
        }
        
        PriorityQueue<Disk> pq=new PriorityQueue<>((o1,o2)->o1.leng-o2.leng);
        
        boolean loop=true;
        
        int time=0;
        int i=0;
        
        while(loop){
            

           while(i<jobs.length){
               Disk now= new Disk(jobs[i][0],jobs[i][1]);      
               if(now.access<=time){
                    i++;
                    pq.add(now);
               }
               else
                    break;
            }


            
            if(!pq.isEmpty()){
                Disk now=pq.poll();
                time+=now.leng;
                answer+=time-now.access;
                continue;
            }
            
            if(i==jobs.length&&pq.isEmpty())
                loop=false;
            
            time++;
        }
        
        answer/=jobs.length;
        
        return answer;
    }
}