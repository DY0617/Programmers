import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        class Node{
            int prior,idx;
            Node(int a, int b){
                prior=a;
                idx=b;
            }
        }
        
        
        Queue<Node> q=new LinkedList<>();
        
        int size=priorities.length;
        
        int max=-1;
        
        for(int i=0;i<size;i++){
            q.add(new Node(priorities[i],i));  
            max=Math.max(max,priorities[i]);
        }
        
        int count=0;

        
        while(!q.isEmpty()){
            Node node=q.poll();
            
            
            
            if(max>node.prior){
                q.add(node);
            }
            else{
                count++;
                
                if(node.idx==location)
                    break;
                
                priorities[node.idx]=-1;
                max=-1;
                
                for(int i=0;i<size;i++){
                    max=Math.max(max,priorities[i]);
                }

            }
        }
        
        answer=count;
        
        return answer;
    }
}