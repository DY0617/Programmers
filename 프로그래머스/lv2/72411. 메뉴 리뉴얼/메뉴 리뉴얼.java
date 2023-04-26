import java.util.*;

class Solution {
    
    ArrayList<ArrayList<String>> order=new ArrayList<>();
    int[] courseCnt;
    
    
    ArrayList<ArrayList<String>> list=new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        String[] answer={};
        
        for(int i=0;i<orders.length;i++){
            order.add(new ArrayList<String>());
            for(int j=0;j<orders[i].length();j++){
                order.get(i).add(String.valueOf(orders[i].charAt(j)));
            }
            Collections.sort(order.get(i));
        }
        
        courseCnt=course;
        Arrays.sort(courseCnt);
        
        for(int i=0;i<courseCnt.length;i++)
            list.add(new ArrayList<String>());
        
        int idx=0;
        
        for(int cnt:courseCnt){
            for(int i=0;i<order.size();i++)
                dfs("",idx,cnt,0,i);
            idx++;
        }
        
        ArrayList<String> ans=new ArrayList<>();
        
        for(ArrayList<String> nowList:list){
            ArrayList<String> temp=new ArrayList<>();
            int max=2;
            for(String now:nowList){
                int cnt=0;
                for(String nowOrder:orders){
                    boolean istrue=true;
                    for(int i=0;i<now.length();i++){
                        if(!nowOrder.contains(String.valueOf(now.charAt(i)))){
                            istrue=false;
                            break;
                        }
                    }
                    if(istrue)
                        cnt++;
                }
                if(max<cnt){
                    max=cnt;
                    temp=new ArrayList<>();
                    temp.add(now);
                }
                else if(max==cnt){
                    temp.add(now);
                }
            }
            
            for(String str:temp){
                ans.add(str);
            }
        }
        
        /*
        for(ArrayList<String> nowList:list){
            for(int i=0;i<nowList.size();i++){
                System.out.print(nowList.get(i)+" ");
            }
            System.out.println();
        }
        */
        
        Collections.sort(ans);
        
        answer=new String[ans.size()];
        
        idx=0;
        
        for(String now:ans){
            answer[idx++]=now;
        }
        
        return answer;
    }
    
    void dfs(String str,int listIdx,int max,int nowIdx,int orderIdx){
        if(str.length()==max){
            if(!list.get(listIdx).contains(str))
                list.get(listIdx).add(str);
            return;
        }
        if(order.get(orderIdx).size()==nowIdx)
            return;
        
        String nextStr=str+order.get(orderIdx).get(nowIdx++);

        
        dfs(nextStr,listIdx,max,nowIdx,orderIdx);
        dfs(str,listIdx,max,nowIdx,orderIdx);
        
    }
}