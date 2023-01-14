import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max1=-1;
        int max2=-1;
        
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][1]>sizes[i][0]){
                int temp=sizes[i][0];
                sizes[i][0]=sizes[i][1];
                sizes[i][1]=temp;
            }
            max1=Math.max(max1,sizes[i][0]);
            max2=Math.max(max2,sizes[i][1]);
        }
        
        
        
        return answer=max1*max2;
    }
}