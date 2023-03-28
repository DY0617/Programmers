import java.util.*;

class Solution {
    int answer,n;
    String[] data;
    String[] name={"A","C","F","J","M","N","R","T"};

    public int solution(int n, String[] data) {
        answer = 0;
        this.n=n;
        this.data=data;
        
        
        
        dfs("");
        
        
        return answer;
    }
    
    public void dfs(String str){
        
        if(str.length()==8){
            
            boolean istrue=true;
            
            for(int i=0;i<n;i++){
                
                
                StringTokenizer st=new StringTokenizer(data[i],"~=<>",true);
                String first=st.nextToken();
                st.nextToken();
                String second=st.nextToken();
                String op=st.nextToken();
                int checkNum=Integer.parseInt(st.nextToken());
                
                int idx1=str.indexOf(first);
                int idx2=str.indexOf(second);
                int interval=Math.abs(idx1-idx2)-1;
                
                
                
                if(op.equals("=")){
                    
                    if(interval==checkNum){
                        continue;
                    }    
                    else{
                        istrue=false;
                        break;
                    }
                }
                if(op.equals("<")){
                    
                    if(interval<checkNum){
                        continue;
                    }
                    else{
                        istrue=false;
                        break;
                    }
                }
                if(op.equals(">")){
                    if(interval>checkNum){
                        continue;
                    }
                    else{
                        istrue=false;
                        break;
                    }
                }
            }
            
            if(istrue){
                answer++;
            }
                
            
            return;
        }
        
        for(String now:name){
            if(!str.contains(now)){
                String nowStr=str+now;
                dfs(nowStr);
            }
        }
        
        return;
    }
}