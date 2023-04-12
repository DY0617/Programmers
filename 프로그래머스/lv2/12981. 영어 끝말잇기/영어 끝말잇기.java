import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> list=new HashSet<>();
        
        list.add(words[0]);
        char lastChar=words[0].charAt(words[0].length()-1);
        
        for(int i=1;i<words.length;i++){
            if(list.contains(words[i])
              ||lastChar!=words[i].charAt(0)){
                answer[0]=(i%n)+1;
                answer[1]=(i/n)+1;
                
                break;
            }
            list.add(words[i]);
            lastChar=words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}