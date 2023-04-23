import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        StringBuilder sb;
        
        for(int[] q:queries){
            sb=new StringBuilder();
            int s=q[0];
            int e=q[1];
            String str1=answer.substring(0,s);
            sb.append(answer.substring(s,e+1));
            sb.reverse();
            String str2=answer.substring(e+1);
            
            //System.out.println(str1+" "+sb.toString()+" "+str2);
            
            answer=str1+sb.toString()+str2;
        }
        
        return answer;
    }
}