import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    static String target;
    static String[] word;
    public int solution(String begin, String tg, String[] words) {
        answer = Integer.MAX_VALUE;
        
        visited=new boolean[words.length];
        target=tg;
        word=words;
        
        dfs(0,begin);
        
        if(answer==Integer.MAX_VALUE)
            answer=0;
        
        return answer;
    }
    
    static void dfs(int depth,String str){
        
        if(str.equals(target)){
            answer=Math.min(answer,depth);
        }
        
        for(int i=0;i<word.length;i++){
            if(visited[i])
                continue;
            int cnt=0;
            for(int j=0;j<word[i].length();j++){
                if(word[i].charAt(j)!=str.charAt(j))
                    cnt++;
            }
            if(cnt==1){
                visited[i]=true;
                dfs(depth+1,word[i]);
                visited[i]=false;
            }

        }
        
    }
}