import java.util.*;

class Solution {
    
    static ArrayList[] list;
    static boolean[] visited;
    static int[] distance;
    static int max=0;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        list=new ArrayList[n+1];
        visited=new boolean[n+1];
        distance=new int[n+1];
        
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<Integer>();
        }
        
        
        for(int i=0;i<edge.length;i++){
            int a=edge[i][0];
            int b=edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        distance[1]=1;
        
        Queue<Integer> pq=new LinkedList<>();
        
        pq.add(1);
        
        while(!pq.isEmpty()){
            int now=pq.poll();
            
            for(int i=0;i<list[now].size();i++){
                int next=(int)list[now].get(i);
                if(distance[next]==0){
                    pq.add(next);
                    distance[next]=distance[now]+1;
                    max=Math.max(max,distance[next]);
                }
            }
            
        }
        
        
        for(int now : distance){
            if(now==max)
                answer++;
        }
        
        return answer;
    }
    
}