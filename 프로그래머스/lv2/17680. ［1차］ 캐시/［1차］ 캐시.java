import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        ArrayList<String> lru=new ArrayList<>();
        
        for(String str:cities){
            str=str.toLowerCase();
            if(lru.contains(str)){
                lru.remove(str);
                lru.add(str);
                answer++;
            }
            else{
                if(cacheSize!=0){
                    if(lru.size()==cacheSize){
                        lru.remove(0);
                    }
                    lru.add(str);
                }
                
                answer+=5;
            }
            

        }
        
        return answer;
    }
}