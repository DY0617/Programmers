import java.util.*;

class Solution {
    
    static ArrayList[] list;
    static boolean[] visited;
    static int[] summits;
    static int[] intensity;
    static int minIntensity=Integer.MAX_VALUE;
    static int gateNum=Integer.MAX_VALUE;
    
        static class Node{
            int to;
            int cost;
            Node(int a,int b){
                to=a;
                cost=b;
            }
        }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        this.summits=summits;
        visited=new boolean[n+1];
        intensity=new int[n+1];
        Arrays.fill(intensity,Integer.MAX_VALUE);
        Arrays.sort(summits);
        

        
        list=new ArrayList[n+1];
        
        for(int i=1;i<list.length;i++){
            list[i]=new ArrayList<Node>();
        }
        
        for(int[] path:paths){
            boolean isGate=false;
            boolean isSummit=false;
            for(int gate:gates){
                if(gate==path[0]){
                    isGate=true;
                }
            }
            for(int summit:summits){
                if(summit==path[1]){
                    isSummit=true;
                }
            }
            if(isGate||isSummit){
                list[path[0]].add(new Node(path[1],path[2]));
                continue;
            }
            isGate=false;
            isSummit=false;
            for(int gate:gates){
                if(gate==path[1]){
                    isGate=true;
                }
            }
            for(int summit:summits){
                if(summit==path[0]){
                    isSummit=true;
                }
            }
            if(isGate||isSummit){
                list[path[1]].add(new Node(path[0],path[2]));
                continue;
            }
            list[path[0]].add(new Node(path[1],path[2]));
            list[path[1]].add(new Node(path[0],path[2]));
        }
        
        Queue<Node> q=new LinkedList<>();
        
        for(int gate:gates){
            q.add(new Node(gate,0));
            intensity[gate]=0;
        }
        
        while(!q.isEmpty()){
            Node node=q.poll();
            
            if(node.cost<=intensity[node.to]){
                for(int i=0;i<list[node.to].size();i++){
                    Node next=(Node)list[node.to].get(i);
                    
                    int nowCost=Math.max(intensity[node.to],next.cost);
                    if(intensity[next.to]>nowCost){
                        intensity[next.to]=nowCost;
                        q.add(new Node(next.to,nowCost));
                    }
                    
                }
            }
        }
        
        for (int summit : summits) {
            System.out.println(intensity[summit]);
            if (intensity[summit] < minIntensity) {
                gateNum = summit;
                minIntensity = intensity[summit];
            }
        }
        
        
        answer[0]=gateNum;
        answer[1]=minIntensity;
        
        return answer;
    }
    
}