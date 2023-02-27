import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num=0;
        String str="0";
        
        int strLen=t*m;
        
        while(strLen>str.length()){
            String now="";
            int nowNum=num;
            
            while(nowNum!=0){
                int change=nowNum%n;
                if(change>=10){
                    change=change-10+'A';
                    char changeNum=(char)change;
                    now=String.valueOf(changeNum)+now;
                }
                else{
                    now=String.valueOf(change)+now;
                }
                nowNum=nowNum/n;
                
                
            }
            str+=now;
            num++;
        }
        
        
        for(int i=0;i<t;i++){
            int idx=i*m+p-1;
            answer+=String.valueOf(str.charAt(idx));
        }
        
        return answer;
    }
}