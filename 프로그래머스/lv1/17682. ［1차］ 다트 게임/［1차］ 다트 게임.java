import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int num=0;
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int i=0;i<dartResult.length();i++){
            if('1'==dartResult.charAt(i)&&dartResult.charAt(i+1)=='0'){
                list.add(num);
                num=10;
                i++;
                continue;
            }
            else if('0'<=dartResult.charAt(i)&&dartResult.charAt(i)<='9'){
                list.add(num);
                num=Integer.parseInt(String.valueOf(dartResult.charAt(i)));
                continue;
            }
            
            if(dartResult.charAt(i)=='S'){
                num=(int)Math.pow(num,1);               
            }
            else if(dartResult.charAt(i)=='D'){
                num=(int)Math.pow(num,2);
            }
            else if(dartResult.charAt(i)=='T'){
                num=(int)Math.pow(num,3);
            }
            else if(dartResult.charAt(i)=='*'){
                num=num*2;
                if(list.size()!=0){
                    list.set(list.size()-1,list.get(list.size()-1)*2);
                }
            }
            else{
                num=num*(-1);
            }
        }
        

        for(int now:list)
            answer+=now;
        
        answer+=num;
        
        return answer;
    }
}