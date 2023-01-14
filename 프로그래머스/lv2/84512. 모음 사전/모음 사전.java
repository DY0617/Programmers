import java.util.*;

class Solution {
    
    static ArrayList<String> list=new ArrayList<>();
    static String[] arr={"A","E","I","O","U"};
    
    public int solution(String word) {
        int answer = 0;
        
        dfs(0,"");
        
        answer=list.indexOf(word);
        
        
        return answer;
    }
    
    static void dfs(int depth,String str){
        if(!list.contains(str))
            list.add(str);
        if(depth==5)
            return;
        
        for(int i=0;i<arr.length;i++){
            String now=str+arr[i];
            dfs(depth+1,now);
        }
    }
}