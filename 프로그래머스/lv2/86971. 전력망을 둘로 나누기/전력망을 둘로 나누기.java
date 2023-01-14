import java.util.*;
class Solution {
    
    static ArrayList[] list;
    static boolean[] visited;
    static int size;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        list=new ArrayList[n+1];
        visited=new boolean[n+1];
        size=wires.length;
        
        
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<Integer>();
        }
        


        
        for(int i=0;i<wires.length;i++){
            int from=wires[i][0];
            int to=wires[i][1];
            list[from].add(to);
            list[to].add(from);
        }

        

        for(int i=0;i<wires.length;i++){
            Arrays.fill(visited,false);
            int a=wires[i][0];
            int b=wires[i][1];
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            int result=bfs(a,b);
            answer=Math.min(answer,result);
            list[a].add(b);
            list[b].add(a);
        }


        
        return answer;
    }
    

    static int bfs(int a,int b){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int num=1;
        for(int i=1;i<visited.length;i++){
            if(i!=a&&i!=b){
                num=i;
                break;
            }
        }
        pq.add(num);
        int count=-1;
        
        while(!pq.isEmpty()){
            count++;
            int now=pq.poll();
            visited[now]=true;
            
            for(int i=0;i<list[now].size();i++){
                int next=(int)list[now].get(i);   
                if(!visited[next]){     
                    pq.add(next);
                }

            }
            
        }
        
        int other=size-1-count;
        
        int total=Math.abs(count-other);
        
        
        return total;
        
    }

    
}