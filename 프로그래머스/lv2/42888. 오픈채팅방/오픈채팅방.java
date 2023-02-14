import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        class Member{
            String id;
            boolean inOut;
            Member(String a,boolean inout){
                id=a;
                inOut=inout;
            }
        }
        
        Map<String,String> list=new HashMap<>();
        StringTokenizer st;
        ArrayList<Member> result=new ArrayList<>();
        
        for(String str:record){
            st=new StringTokenizer(str);
            String command=st.nextToken();
            if(command.equals("Enter")){
                String id=st.nextToken();
                String name=st.nextToken();
                list.put(id,name);
                result.add(new Member(id,true));
            }
            else if(command.equals("Change")){
                String id=st.nextToken();
                String name=st.nextToken();
                list.put(id,name);
            }
            else if(command.equals("Leave")){
                String id=st.nextToken();
                result.add(new Member(id,false));
            }
        }
        
        answer=new String[result.size()];
        
        for(int i=0;i<answer.length;i++){
            Member member=result.get(i);
            if(member.inOut){
                answer[i]=list.get(member.id)+"님이 들어왔습니다.";
            }
            else{
                answer[i]=list.get(member.id)+"님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}