import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String,Integer> list=new HashMap<>();
        s=s.toLowerCase();
        
        list.put("zero",0);
        list.put("one",1);
        list.put("two",2);
        list.put("three",3);
        list.put("four",4);
        list.put("five",5);
        list.put("six",6);
        list.put("seven",7);
        list.put("eight",8);
        list.put("nine",9);
        
        for(String key:list.keySet()){
            if(s.contains(key)){
                s=s.replace(key,String.valueOf(list.get(key)));
            }
        }
        
        answer=Integer.parseInt(s);
        
        return answer;
    }
}