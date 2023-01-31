import java.util.*;

class Solution {
    
    static ArrayList[] tree;
    static int[] info;
    static int max=0;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        this.info=info;
        
        tree=new ArrayList[info.length];
        for(int i=0;i<tree.length;i++){
            tree[i]=new ArrayList<Integer>();
        }
        
        for(int[] edge:edges){
            tree[edge[0]].add(edge[1]);
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);

        dfs(0,0,0,list);
        
        answer=max;
        return answer;
    }
    
    public static void dfs(int now, int sheep,int wolf,ArrayList<Integer> nextList){
        if(info[now]==0)
            sheep++;
        else
            wolf++;
        
        if(wolf>=sheep)
            return;
        
        max=Math.max(max,sheep);
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<nextList.size();i++){
            int next=nextList.get(i);
            if(next!=now)
                list.add(next);
        }
        for(int i=0;i<tree[now].size();i++){
            list.add((int)tree[now].get(i));
        }
        
        for(int nextNode:list){
            dfs(nextNode,sheep,wolf,list);
        }
        
    }
    
    
}