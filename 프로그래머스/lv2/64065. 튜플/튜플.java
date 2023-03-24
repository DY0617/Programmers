import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        StringTokenizer st=new StringTokenizer(s,"{}");
        ArrayList<String> list=new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }
        
        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
        
        while(list.remove(",")){}
        
        
        ArrayList<Integer> ansList=new ArrayList<>();
        int[] answer=new int[list.size()];
        
        for(int i=0;i<answer.length;i++){
            st=new StringTokenizer(list.get(i),",");
            while(st.hasMoreTokens()){
                int now=Integer.parseInt(st.nextToken());
                if(!ansList.contains(now)){
                    ansList.add(now);
                    answer[i]=now;
                    break;
                }
            }
        }
        
        
        
        
        return answer;
    }
}