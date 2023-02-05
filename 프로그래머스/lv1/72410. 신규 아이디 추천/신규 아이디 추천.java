import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id=new_id.toLowerCase();
        char alStart=97;
        char alEnd=122;
        String str="";
        for(int i=0;i<new_id.length();i++){
            if((alStart<=new_id.charAt(i)&&new_id.charAt(i)<=alEnd)||new_id.charAt(i)=='-'||new_id.charAt(i)=='_'
              ||new_id.charAt(i)=='.'||(48<=new_id.charAt(i)&&new_id.charAt(i)<=57)){
                str+=String.valueOf(new_id.charAt(i));
            }
        }
        
        
        int idx=0;
        while(idx<str.length()-1){
            if(str.charAt(idx)=='.'&&str.charAt(idx+1)=='.'){
                str=str.substring(0,idx+1)+str.substring(idx+2);
            }
            else
                idx++;
        }
        
        
        
        while(str.charAt(0)=='.'){
            if(str.length()==1){
                str="";
                break;
            }
            else{
                str=str.substring(1);
            }
        }
        
        if(!str.equals("")){
            while(str.charAt(str.length()-1)=='.'){
                str=str.substring(0,str.length()-1);
            }
        }
        
        if(str.equals(""))
            str="a";
        
        if(str.length()>=16){
            str=str.substring(0,15);
            while(str.charAt(str.length()-1)=='.'){
                str=str.substring(0,str.length()-1);
            }
        }
        
        if(str.length()<=2){
            while(str.length()<3){
                str+=str.charAt(str.length()-1);
            }
        }
        
        answer=str;
        
        return answer;
    }
}