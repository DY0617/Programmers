import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes,(o1,o2)->o1[1]-o2[1]);
        
        int min=0;
        
        int i=1;

        while(i<routes.length){
            if(routes[i][0]<=routes[min][1]){
                i++;
                if(i==routes.length)
                    answer++;
            }
            else{
                min=i;
                answer++;
            }
        }
        
        return answer;
    }
}