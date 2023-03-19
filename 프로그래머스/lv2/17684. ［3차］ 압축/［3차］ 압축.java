import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        
        HashMap<String,Integer> list=new HashMap<>();
        
        char nowAlp='A';
        
        for(int i=1;i<=26;i++){
            String nowStr=String.valueOf(nowAlp);
            list.put(nowStr,i);   
            nowAlp++;
        }
        
        int wcIdx=27;
        
        ArrayList<Integer> ans=new ArrayList<>();
        

        
        while(!msg.equals("")){
            String str="";
            int idx=1;
            while(!msg.equals("")){
                if(idx<=msg.length()){
                    if(list.containsKey(msg.substring(0,idx))){
                        str=msg.substring(0,idx);
                        idx++;
                    }
                    else
                        break;
                    
                }
                else
                    break;
            }
            
            msg=msg.substring(idx-1,msg.length());
            
            ans.add(list.get(str));
            

            if(msg.length()>1){
                list.put(str+msg.substring(0,1),wcIdx++);
                
            }
            else if(msg.length()==1){
                ans.add(list.get(msg));
                break;
            }
            else{
                
                break;
            }

     
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        
        return answer;
    }
}