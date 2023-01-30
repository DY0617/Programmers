import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String,Set<String>> list=new HashMap<>();
        Map<String,Integer> idx=new HashMap<>();
        int j=0;
        
        for(String str:id_list){
            list.put(str,new HashSet<>());
            idx.put(str,j++);
        }
        StringTokenizer st;
        for(String str:report){
            st=new StringTokenizer(str);
            
            String from=st.nextToken();
            String to=st.nextToken();
            
            list.get(to).add(from);
        }
        
        for(int i=0;i<list.size();i++){
            Set<String> now=list.get(id_list[i]);
            if(now.size()>=k){
                for(int a=0;a<id_list.length;a++){
                    if(now.contains(id_list[a])){
                        int nowIdx=idx.get(id_list[a]);
                        answer[nowIdx]++;
                    }
                }
            }
        }
        
        return answer;
    }
}