import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer=new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int start=commands[i][0]-1;
            int end=commands[i][1]-1;
            int loc=commands[i][2]-1;
            int[] arr=new int[end-start+1];
            int now=0;
            for(int j=start;j<=end;j++){
                arr[now]=array[j];
                now++;
            }
            Arrays.sort(arr);
            answer[i]=arr[loc];
            
        }
        
        return answer;
    }
}