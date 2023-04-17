import java.util.*;

class Solution {
    
    String t;
    String[] strs;
    int dp[];
    
    
    public int solve(int idx){
        
        //dp[i]는 i~마지막 문자열을 채울 수 있는 최소 횟수를 의미
        
        //더 이상 진행 불가능
        if(idx == t.length())
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        
        // 최소값을 찾아야 하므로 충분히 큰 값으로 초기화
        dp[idx] = 20001;
        for(int i=0;i<strs.length;i++){
            
            // (현재까지 만들어진 문자열의 길이 + 새로운 퍼즐의 크기)가
            // 단어의 길이보다 짧아야 함
            if(idx + strs[i].length() <= t.length()){
                boolean flag = true;
                // substring으로 잘라서 문자열을 비교할경우 시간초과가 납니다. ㅠㅠ
                // 채워나갈 수 있는 단어인지 검사
                for(int j = 0; j < strs[i].length(); j++) {
                    if(t.charAt(idx + j) != strs[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) 
                    dp[idx] = Math.min(dp[idx], solve(idx + strs[i].length()) + 1);
            }
        }
        return dp[idx];
    }
    
    public int solution(String[] strs, String t) {
        
        dp = new int[t.length()];
        Arrays.fill(dp, -1);
        Arrays.sort(strs, (o1,o2)->o1.length()-o2.length());
        this.strs = strs; this.t = t;
        
        int answer = solve(0);
        return answer = (answer <= 20000) ? answer : -1;
    }
}