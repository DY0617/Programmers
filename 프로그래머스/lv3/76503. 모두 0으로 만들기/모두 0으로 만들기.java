import java.util.*;

class Solution {
    
    long answer;
    boolean[] visited;
    long[] along;
    
    ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    public long solution(int[] a, int[][] edges) {
        answer=0;
        along=new long[a.length];
        visited=new boolean[a.length];
        
        long sum=0;
        
        for(int i=0;i<a.length;i++){
            graph.add(new ArrayList<Integer>());
            sum+=a[i];
            along[i]=a[i];
        }
        
        if(sum != 0) return -1;
        
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        
        visited[0]=true;
        dfs(0);
        
        return answer;
    }
    
    public long dfs(int loc){
        
        for(int i=0;i<graph.get(loc).size();i++){
            int next=graph.get(loc).get(i);
            if(!visited[next]){
                visited[next]=true;
                along[loc]+=dfs(next);
            }
        }
        
        answer+=Math.abs(along[loc]);
        
        return along[loc];
    }
}
