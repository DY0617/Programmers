import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count=0;
        int zeroCount=0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int lottoIdx=0;
        int winIdx=0;
        
        int length=lottos.length;
        
        while(lottoIdx<length&&winIdx<length){
            
            if(lottos[lottoIdx]==0){
                zeroCount++;
                lottoIdx++;
                continue;
            }
            
            if(lottos[lottoIdx]==win_nums[winIdx]){
                count++;
                lottoIdx++;
                winIdx++;
            }
            else if(lottos[lottoIdx]>win_nums[winIdx]){
                winIdx++;
            }
            else
                lottoIdx++;
        }
        
        int maxCount=zeroCount+count;
        
        int[] rank={6,5,4,3,2,1};
        
        if(maxCount==0)
            maxCount=1;
        
        answer[0]=rank[maxCount-1];
        
        if(count==0)
            count=1;
        answer[1]=rank[count-1];
        
        return answer;
    }
}