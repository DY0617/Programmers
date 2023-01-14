import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }     
        
                
        Arrays.sort(str, (o1,o2)->(o2+o1).compareTo(o1+o2));       
        
        if (str[0].equals("0")) return "0";
        
        for(String s: str) answer += s;
 
        return answer;
    }
}