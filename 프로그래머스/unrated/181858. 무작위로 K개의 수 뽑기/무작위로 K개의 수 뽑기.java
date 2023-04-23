import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        
        
        Set<Integer> set=new HashSet<>();
        
        
        int idx=0;
        
        Arrays.fill(answer,-1);
        
        for(int i=0;i<arr.length;i++){
            if(idx==answer.length)
                break;
            if(!set.contains(arr[i])){
                set.add(arr[i]);
                answer[idx++]=arr[i];
            }
        }
        
        return answer;
    }
}