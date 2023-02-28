import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] sort=new String[files.length][3];
        
        for(int i=0;i<sort.length;i++)
            Arrays.fill(sort[i],"");
        
        for(int i=0;i<files.length;i++){
            String now=files[i];
            
            
            int state=0;
            
            for(int j=0;j<now.length();j++){
                if(state==0){
                    if(Character.isDigit(now.charAt(j))){
                        state=1;
                        sort[i][1]+=String.valueOf(now.charAt(j));
                    }
                    else{
                        sort[i][0]+=String.valueOf(now.charAt(j));
                    }
                }
                
                else if(state==1){
                    if(!Character.isDigit(now.charAt(j))){
                        state=2;
                        sort[i][2]+=String.valueOf(now.charAt(j));
                    }
                    else{
                        sort[i][1]+=String.valueOf(now.charAt(j));
                    }
                }
                else{
                    sort[i][2]+=String.valueOf(now.charAt(j));
                }
                
            }
            
            
        }
        
        Arrays.sort(sort,(o1,o2)->{
            if(!o1[0].toLowerCase().equals(o2[0].toLowerCase())){
                return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
            }
            else if(Integer.parseInt(o1[1])!=Integer.parseInt(o2[1])){
                return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            }
            else
                return 0;
        });
        
        for(int i=0;i<sort.length;i++){
            answer[i]=sort[i][0]+sort[i][1]+sort[i][2];
        }
        
        return answer;
    }
}