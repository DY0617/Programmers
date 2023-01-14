import java.util.*;

class Solution {
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        ArrayList[] list=new ArrayList[computers.length];
        
        for(int i=0;i<computers.length;i++){
            list[i]=new ArrayList<Integer>();
        }
        
        for(int i=0;i<computers.length;i++){
            for(int j=i+1;j<computers[i].length;j++){
                if(computers[i][j]==1){
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        boolean[] visited=new boolean[computers.length];
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int start=0;start<computers.length;start++){
            
            if(!visited[start]){
                pq.add(start);
        
                while(!pq.isEmpty()){
                    int now=pq.poll();
                    int size=list[now].size();
            
                    for(int i=0;i<size;i++){
                        if(visited[(int)list[now].get(i)])
                            continue;
                        pq.add((int)list[now].get(i));
                        visited[(int)list[now].get(i)]=true;
                    }
                }
                answer++;
            }
   
        }
        return answer;
    }
}