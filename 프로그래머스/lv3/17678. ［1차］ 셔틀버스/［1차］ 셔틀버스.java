import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        ArrayList<Integer> list=new ArrayList<>();
        StringTokenizer st;
        
        for(int i=0;i<timetable.length;i++){
            st=new StringTokenizer(timetable[i],":");
            int clock=Integer.parseInt(st.nextToken())*60;
            int minute=Integer.parseInt(st.nextToken());
            list.add(clock+minute);
        }
        
        Collections.sort(list);
        
        int time=540;
        
        for(int i=0;i<n;i++){
            if(i==n-1){
                /*
                System.out.println("time: "+time);
                for(int now:list){
                    System.out.println(now);
                }
                */
                
                if(list.size()==m){
                    if(time>=list.get(list.size()-1)){
                        int now=list.get(list.size()-1)-1;
                        String clock=String.valueOf(now/60);
                        String minute=String.valueOf(now%60);
                        if(clock.length()==1){
                            clock="0"+clock;
                        }
                        if(minute.length()==1){
                            minute="0"+minute;
                        }
                        answer=clock+":"+minute;
                    }
                    else{
                        String clock=String.valueOf(time/60);
                        String minute=String.valueOf(time%60);
                        if(clock.length()==1){
                            clock="0"+clock;
                        }
                        if(minute.length()==1){
                            minute="0"+minute;
                        }
                        answer=clock+":"+minute;
                    }
                }
                else if(list.size()>m){
                    if(time>=list.get(m-1)){
                        int now=list.get(m-1)-1;
                        String clock=String.valueOf(now/60);
                        String minute=String.valueOf(now%60);
                        if(clock.length()==1){
                            clock="0"+clock;
                        }
                        if(minute.length()==1){
                            minute="0"+minute;
                        }
                        answer=clock+":"+minute;
                    }
                    else{
                        String clock=String.valueOf(time/60);
                        String minute=String.valueOf(time%60);
                        if(clock.length()==1){
                            clock="0"+clock;
                        }
                        if(minute.length()==1){
                            minute="0"+minute;
                        }
                        answer=clock+":"+minute;
                    }
                }
                else{
                    String clock=String.valueOf(time/60);
                    String minute=String.valueOf(time%60);
                    if(clock.length()==1){
                        clock="0"+clock;
                    }
                    if(minute.length()==1){
                        minute="0"+minute;
                    }
                    answer=clock+":"+minute;
                }
            }
            else{
                int count=0;
                while(count<m){
                    if(!list.isEmpty()){
                        int now=list.get(0);
                        if(now<=time){
                            list.remove(0);
                            count++;
                        }
                        else
                            break;
                    }
                    else{
                        break;
                    }
                }
            }
            
            time+=t;
        }
        
        return answer;
    }
}