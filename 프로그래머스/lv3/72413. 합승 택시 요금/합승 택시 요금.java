import java.util.*;

class Solution {
    
    static ArrayList[] graph;
    static int[] djk1;
    static int[] djk2;
    static int[] djk;
    static int s,a,b;
    static int aDistance=Integer.MAX_VALUE;
    static int bDistance=Integer.MAX_VALUE;
    
        static class Node{
            int to,weight;
            Node(int a,int b){
                to=a;
                weight=b;
            }
        }
    
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        this.s=s;
        this.a=a;
        this.b=b;
        

        
        int answer = Integer.MAX_VALUE;
        
        graph=new ArrayList[n+1];
        djk=new int[n+1];
        djk1=new int[n+1];
        djk2=new int[n+1];
        
        Arrays.fill(djk1,Integer.MAX_VALUE);
        Arrays.fill(djk2,Integer.MAX_VALUE);
        Arrays.fill(djk,Integer.MAX_VALUE);
        
        for(int i=1;i<graph.length;i++)
            graph[i]=new ArrayList<Node>();
        
        for(int[] fare:fares){
            graph[fare[0]].add(new Node(fare[1],fare[2]));
            graph[fare[1]].add(new Node(fare[0],fare[2]));
        }
        
        djk1[a]=0;
        djk2[b]=0;
        djk[s]=0;
        
        
        dijkstra(a,djk1);
        dijkstra(b,djk2);
        dijkstra(s,djk);
        
        System.out.println(djk1[s]+" "+djk2[s]+" "+djk[a]+" "+djk[b]);
        
        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, djk1[i] + djk2[i] + djk[i]);
        
        return answer;
    }
    
    
    public static void dijkstra(int a,int[] cost){
        
        PriorityQueue<Node> q=new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
        
        q.add(new Node(a,0));        
        
        while(!q.isEmpty()){
            
            Node next=q.poll();
            
            if(next.weight>cost[next.to]) continue;
            
            for(int i=0;i<graph[next.to].size();i++){
                Node node=(Node)graph[next.to].get(i);
                int nowWeight=node.weight+cost[next.to];
                if(nowWeight<cost[node.to]){
                    cost[node.to]=nowWeight;
                    q.add(new Node(node.to,nowWeight));
                }
            }
            
        }
        
        
    }
    
}