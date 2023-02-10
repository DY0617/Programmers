import java.util.*;

class Solution {
    
    
    public String solution(String p) {
        String answer = "";
      
        answer=recursion(p);
        
        return answer;
    }
    
    public static String recursion(String str){
        String u="",v="";
        
        if(!str.equals("")){             
            int count1=0,count2=0;             
            boolean isTrue=true;            
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='('){
                    u+="(";
                    count1++;
                }
                else{
                    u+=")";
                    count2++;
                }                   
                if(count1==count2){                    
                    v=str.substring(i+1);                   
                    break;
                }
            }

            Stack<String> stack=new Stack<>();
            
            for(int i=0;i<u.length();i++){                
                if(u.charAt(i)=='('){
                    stack.add("(");
                }
                else{
                    if(!stack.isEmpty()){
                        if(stack.peek().equals("(")){
                            stack.pop();
                        }
                        else{
                            isTrue=false;
                            break;
                        }
                    } 
                    else{
                        isTrue=false;
                        break;
                    }
                }
            }
            
            if(isTrue){
                v=recursion(v);
                return u+v;
            }
            else{
                String s="(";
                s+=recursion(v);
                s+=")";
                u=u.substring(1,u.length()-1);
                String S="";
                for(int i=0;i<u.length();i++){
                    if(u.charAt(i)=='('){
                        S+=")";
                    }
                    else
                        S+="(";
                }
                s+=S;
                return s;
            }
            
        }
        
        return str;
    }
    

}