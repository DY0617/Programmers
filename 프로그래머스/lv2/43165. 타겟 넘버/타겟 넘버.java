import java.util.*;

class Solution {
    static int[] num;
    static int tg;
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        tg=target;
        num=numbers;
        
        dfs(0,0);
        
        return answer;
    }
    
    public static void dfs(int depth,int total){
        if(depth==num.length){
            if(total==tg)
                answer++;
            return;
        }
        
        dfs(depth+1,total+num[depth]);
        dfs(depth+1,total-num[depth]);
    }
}