import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx=0,bIdx=0;
        
        while(bIdx!=B.length){
            
            if(A[aIdx]<B[bIdx]){
                answer++;
                aIdx++;
                bIdx++;
            }
            else{
                bIdx++;
            }
        }
        
        return answer;
    }
}