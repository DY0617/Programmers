class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] dp=new int[202];
        
        for(int[] line:lines){
            int a=line[0]+100;
            int b=line[1]+100;
            
            dp[a]++;
            dp[b]--;
        }
        
        for(int i=1;i<dp.length;i++){
            dp[i]+=dp[i-1];
        }
        
        
        for(int i=0;i<dp.length;i++){
            if(dp[i]>1)
                answer++;
        }
        
        
        return answer;
    }
}