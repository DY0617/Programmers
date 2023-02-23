import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        if(str1.equals("")&&str2.equals(""))
            return 65536;
        
        HashMap<String,Integer> sim1=new HashMap<>();
        HashMap<String,Integer> sim2=new HashMap<>();
        
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        
        HashSet<String> union=new HashSet<>();
        
        for(int i=0;i<str1.length()-1;i++){
            String s1=String.valueOf(str1.charAt(i));
            String s2=String.valueOf(str1.charAt(i+1));
            if('a'<=str1.charAt(i)&&str1.charAt(i)<='z'&&
              'a'<=str1.charAt(i+1)&&str1.charAt(i+1)<='z'){
                sim1.put(s1+s2,sim1.getOrDefault(s1+s2,0)+1);
                union.add(s1+s2);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String s1=String.valueOf(str2.charAt(i));
            String s2=String.valueOf(str2.charAt(i+1));
            if('a'<=str2.charAt(i)&&str2.charAt(i)<='z'&&
              'a'<=str2.charAt(i+1)&&str2.charAt(i+1)<='z'){
                sim2.put(s1+s2,sim2.getOrDefault(s1+s2,0)+1);
                union.add(s1+s2);
            }
        }

        int total=0;
        for(String s : union)
            total += Math.max(sim1.getOrDefault(s, 0) , sim2.getOrDefault(s, 0));

        int intersection=0;
        for(String s : sim2.keySet())
            if(sim1.containsKey(s))
                intersection += Math.min(sim1.get(s), sim2.get(s));
        
        if(total==0)
            return 65536;
        
        double simularity=65536*((double)intersection/total);
        answer=(int) simularity;
        
        return answer;
    }
}