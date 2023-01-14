import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int size=nums.length/2;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int next : nums){
            map.put(next,map.getOrDefault(next,0)+1);
        }
        
        int count=0;
        for(int i:map.keySet()){
            count++;
        }
        
        if(count>=size){
            answer=size;
        }
        else
            answer=count;
        
        return answer;
    }
}