import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        
        class Node{
            int to,cost;
            Node(int a, int b){
                to=a;
                cost=b;
            }
        }
        
        int answer = 0;

        int[] dist=new int[N+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        
        ArrayList[] graph=new ArrayList[N+1];
        
        for(int i=1;i<graph.length;i++){
            graph[i]=new ArrayList<Node>();
        }
        
        for(int[] nowNode : road){
            graph[nowNode[0]].add(new Node(nowNode[1],nowNode[2]));
            graph[nowNode[1]].add(new Node(nowNode[0],nowNode[2]));
        }
        
        PriorityQueue<Node> pq=new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node node=pq.poll();
            
            for(int i=0;i<graph[node.to].size();i++){
                Node nextNode=(Node)graph[node.to].get(i);
                if(dist[nextNode.to]<nextNode.cost+node.cost)
                    continue;
                dist[nextNode.to]=nextNode.cost+node.cost;
                pq.add(new Node(nextNode.to,nextNode.cost+node.cost));
            }
        }
        
        for(int i=1;i<dist.length;i++){
            if(dist[i]<=K)
                answer++;
        }
        

        return answer;
    }
}