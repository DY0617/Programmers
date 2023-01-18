import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left=0;
        int right=distance;
        
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid=(left+right)/2;
            int count=0;
            int past=0;
            
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-past<mid)
                    count++;
                else
                    past=rocks[i];
            }
            if(distance - rocks[rocks.length-1] < mid)
                count++;
            if(count <= n) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        
        return answer;
    }
}