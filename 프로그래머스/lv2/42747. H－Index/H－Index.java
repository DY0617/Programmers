import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for(int i=citations.length-1;i>0;i--){
            int h=citations[i]>(i+1)?i+1:citations[i];
            int hCount=0;
            for(int a : citations){
                if(a>=h)
                    hCount++;
            }
            
            System.out.println("h  :"+h+"   hCount  :  "+hCount);
            
            if(h<=hCount){
                answer=h;
                break;
            }
        }
        
        return answer;
    }
}