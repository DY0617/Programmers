import java.util.*;

class Solution {
    
    
    ArrayList<Integer> list=new ArrayList<>();
    
    int l,r;
    
    public int[] solution(int l, int r) {
        int[] answer = {};
        
        this.l=l;
        this.r=r;
        
        dfs("5");
        
        //System.out.println(list.size());
        
        if(list.size()==0){
            answer=new int[1];
            answer[0]=-1;
            return answer;
        }
        
        Collections.sort(list);
        
        answer=new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    void dfs(String str){
        int now=Integer.parseInt(str);
        if(l<=now&&now<=r){
            if(!list.contains(now)){
                list.add(now);
            }
        }
        
        if(now>r)
            return;
        
        dfs(str+"0");
        dfs(str+"5");
    }
}