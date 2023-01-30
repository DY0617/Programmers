import java.util.*;

class Solution {
    
    static int answer;
    public int solution(int n, int k) {
        answer = 0;
        String numK="";
        
        while(n>0){
            numK=n%k+numK;
            n/=k;
        }
        
        StringTokenizer st=new StringTokenizer(numK,"0");
        
        while(st.hasMoreTokens()){
            long prime=Long.parseLong(st.nextToken());
            isPrime(prime);
        }
        
        return answer;
    }
    
    public static void isPrime(long num){
        if(num==0)
            return;
        if(num==1)
            return;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return;
            }
        }
        answer++;
    }
}