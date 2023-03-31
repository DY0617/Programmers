import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int num:numbers)
            list.add(num);
        
        Collections.sort(list);
        
        for(int i=0;i<10;i++){
            if(!list.contains(i))
                answer+=i;
        }
        return answer;
    }
}