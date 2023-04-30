import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] list={"aya","ye","woo","ma"};
        
        
        for(String str:babbling){
            
            String temp="";
            
            boolean aya=true;
            boolean ye=true;
            boolean woo=true;
            boolean ma=true;
            
            while(!temp.equals(str)){
                temp=str;
                if(str.contains("aya")){
                    if(aya){
                        aya=false;
                        str=str.replace("aya",".");
                    }
                }
                if(str.contains("ye")){
                    if(ye){
                        ye=false;
                        str=str.replace("ye",".");
                    }
                }
                if(str.contains("woo")){
                    if(woo){
                        woo=false;
                        str=str.replace("woo",".");
                    }
                }
                if(str.contains("ma")){
                    if(ma){
                        ma=false;
                        str=str.replace("ma",".");
                    }
                }
            }
            
            StringTokenizer st=new StringTokenizer(str,".");
            
            
            
            if(!st.hasMoreTokens()){
                answer++;
            }
            
        }
        
        return answer;
    }
}