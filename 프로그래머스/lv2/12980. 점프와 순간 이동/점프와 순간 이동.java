import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n!=0){
            if(n%2==1){
                n--;
                ans++;
            }
            else{
                n=n/2;
            }
            
        }

        return ans;
    }
}