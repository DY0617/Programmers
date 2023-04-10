import java.util.*;

class Solution {
    
    ArrayList<Integer> list=new ArrayList<>();
    int[] numbers;
    
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        this.numbers=numbers;
        
        dfs(-1,0,0);
        
        Collections.sort(list);
        
        answer=new int[list.size()];

        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
    
    public void dfs(int idx,int depth, int sum){
        if(depth==2){
            if(!list.contains(sum))
                list.add(sum);
            return;
        }
        
        for(int i=idx+1;i<numbers.length;i++){
            dfs(i,depth+1,sum+numbers[i]);
        }
        
        return;
    }
    
}