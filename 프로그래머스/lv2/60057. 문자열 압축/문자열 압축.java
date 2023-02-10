import java.util.*;

class Solution {
    public int solution(String s) {

        String str;
        
        int size=s.length();
        int answer = size;
        
        for(int i=1;i<=size/2;i++){
            str="";
            int last=i*(((size-1)/i));
            String now=s.substring(0,i);
            int count=1;
            for(int j=i;j<size;j=j+i){
                String next;
                if(size>=j+i){
                    next=s.substring(j,j+i);
                }
                else{
                    next=s.substring(j,size);
                }       
                
                
                if(now.equals(next)){
                    count++;
                }
                else{
                    if(count>1){
                        String sAdd=count+now;
                        str+=sAdd;
                        count=1;
                    }
                    else{
                        str+=now;
                    }
                    now=next;
                    //System.out.println(str);
                }
                if(last==j){
                    if(count>1){
                        String sAdd=count+now;
                        str+=sAdd;
                    }
                    else{
                        str+=now;
                    }
                }
            }
            answer=Math.min(answer,str.length());
        }
        
        return answer;
    }
}