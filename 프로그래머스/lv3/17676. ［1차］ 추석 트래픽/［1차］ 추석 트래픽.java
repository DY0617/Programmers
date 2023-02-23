import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        int[][] list=new int[lines.length][2];
        
        for(int i=0;i<lines.length;i++){
            StringTokenizer st=new StringTokenizer(lines[i]);
            String time=st.nextToken();
            time=st.nextToken();
            String runningTime=st.nextToken();
            runningTime=runningTime.substring(0,runningTime.length()-1);
            StringTokenizer st2=new StringTokenizer(time,":");
            int clock=3600*(Integer.parseInt(st2.nextToken()))*1000;
            int minute=60*(Integer.parseInt(st2.nextToken()))*1000;
            double second=Double.parseDouble(st2.nextToken())*1000;
            double runTime=Double.parseDouble(runningTime)*1000;
            
            list[i][0]=clock+minute+(int)second-(int)runTime+1;
            list[i][1]=clock+minute+(int)second;
            
            //System.out.println(list[i][0]+"  "+list[i][1]);
        }
        
        
        for(int i=0;i<list.length;i++){
            int cnt=1;
            for(int j=i+1;j<list.length;j++){
                if(list[i][1] + 999 >= list[j][0]) 
                    cnt ++;
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}