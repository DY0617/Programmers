import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        
        ArrayList<String> list=new ArrayList<>();
        
        StringTokenizer st=new StringTokenizer(myStr,"abc");
        
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        
        
        
        if(list.size()==0){
            answer=new String[1];
            answer[0]="EMPTY";
            return answer;
        }
            
        
        answer=new String[list.size()];
        
        for(int i=0;i<answer.length;i++)
            answer[i]=list.get(i);
        
        return answer;
    }
}