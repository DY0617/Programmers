import java.util.*;

class Solution {
    
    Node[] graph;
    Point[] node;
    ArrayList<Integer> pre=new ArrayList<>();
    ArrayList<Integer> post=new ArrayList<>();
    
    
    public class Point{
        int idx;
        int x,y;
        Point(int a,int b,int c){
            x=a;
            y=b;
            idx=c;
        }
    }
    
    public class Node{
        Point left,right;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        graph=new Node[nodeinfo.length+1];
        node=new Point[nodeinfo.length];
        
        for(int i=1;i<nodeinfo.length+1;i++){
            node[i-1]=new Point(nodeinfo[i-1][0],nodeinfo[i-1][1],i);
            graph[i]=new Node();
        }
        
        Arrays.sort(node,(o1,o2)->o1.y-o2.y);
        
        Point start=node[node.length-1];
        
        
        for(int i=node.length-2;i>=0;i--){
            insert(start,node[i]);
        }
        
        preorder(start.idx);
        postorder(start.idx);
        
        for(int i=0;i<pre.size();i++){
            answer[0][i]=pre.get(i);
            answer[1][i]=post.get(i);
        }
        
        /*for(int i=1;i<graph.length;i++){
            int l=0,r=0;
            
            if(graph[i].left!=null)
                l=graph[i].left.idx;
            
            if(graph[i].right!=null)
                r=graph[i].right.idx;
            
            System.out.println(i+"   "+l+"   "+r);
        }*/
        
        //for(int i=0;i<node.length;i++)
            //System.out.println(node[i].x+"  "+node[i].y+"  "+node[i].idx);
        
        return answer;
    }
    
    public void insert(Point parents,Point child){
        if(parents.x>child.x){
            if(graph[parents.idx].left==null)
                graph[parents.idx].left=child;
            else
                insert(graph[parents.idx].left,child);
        }
        else{
            if(graph[parents.idx].right==null)
                graph[parents.idx].right=child;
            else{
                insert(graph[parents.idx].right,child);
            }
                
        }
    }
    
    public void preorder(int now){
        
        pre.add(now);
        
        if(graph[now].left!=null){
            preorder(graph[now].left.idx);
        }
        if(graph[now].right!=null){
            preorder(graph[now].right.idx);
        }
        
    }
    
    public void postorder(int now){  
        
        if(graph[now].left!=null){
            postorder(graph[now].left.idx);
        }
        if(graph[now].right!=null){
            postorder(graph[now].right.idx);
        }
        
        post.add(now);
    }
    
}