import java.util.*;

class Solution {
    
    ArrayList[] list;
    Set<String> courseName=new HashSet<>();
    ArrayList<String> name=new ArrayList<>();
    int max=2;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        list=new ArrayList[orders.length];
        
        for(int i=0;i<orders.length;i++){
            String str=orders[i];
            list[i]=new ArrayList<String>();
            for(int j=0;j<str.length();j++){
                list[i].add(String.valueOf(str.charAt(j)));
            }
            Collections.sort(list[i]);
        }
        
        Arrays.sort(course);
        
        for(int i=0;i<course.length;i++){
            for(int j=0;j<list.length;j++){
                chooseMenu(course[i],"",j,0);
            }
            for(int j=0;j<courseName.size();j++){
                Iterator iter = courseName.iterator();
                while(iter.hasNext()) {
                    name.add(String.valueOf(iter.next()));
                }
                System.out.println();
                courseName=new HashSet<>();
            }
            max=2;

        }
        
        answer=new String[name.size()];
        
        Collections.sort(name);
        
        for(int i=0;i<name.size();i++){
            answer[i]=name.get(i);
        }
        
        return answer;
    }
    
    public void chooseMenu(int count,String str,int listNum,int idx){
        if(str.length()==count){
            dfs(str,listNum,0,0);
            return;
        }
        
        if(idx+1<=list[listNum].size()){
            chooseMenu(count,str,listNum,idx+1);
            str+=list[listNum].get(idx);
            chooseMenu(count,str,listNum,idx+1);
        }
    }
    
    public void dfs(String str,int listNum,int idx,int total){
        if(idx==list.length){
            if(max<total){
                max=total;
                courseName=new HashSet<>();
                courseName.add(str);
            }
            else if(max==total){
                courseName.add(str);
            }
            return;  
        }

        if(idx==listNum){
            dfs(str,listNum,idx+1,total+1);
            return;
        }

        
        int a=0;
        int count=0;
        for(int i=0;i<list[idx].size();i++){
            if(list[idx].get(i).equals(String.valueOf(str.charAt(a)))){
                count++;
                a++;
                if(a==str.length())
                    break;
            }
        }
        
        if(count==str.length()){
            dfs(str,listNum,idx+1,total+1);
        }
        else{
            dfs(str,listNum,idx+1,total);
        }
        
        return;
    }
}