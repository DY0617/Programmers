class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            if(check(i)){
                answer+=i;
            }
            else{
                answer-=i;
            }
                
        }
        
        
        return answer;
    }
    
    private boolean check(int now){
        int cnt=0;
        for(int i=1;i<=now;i++){
            if(now%i==0){
                cnt++;
            }
        }
        
    
        
        if(cnt%2==0)
            return true;
        else
            return false;
    }
}