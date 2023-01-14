import java.util.*;

class Solution {
    
    static int answer;
    static int[][] dungeon;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon=dungeons;
        visited=new boolean[dungeon.length];
        
        dfs(k,0);
        
        return answer;
    }
    
    public static void dfs(int now,int count){
    
        boolean visit=false;
        
        for(int i=0;i<dungeon.length;i++){
            if(now>=dungeon[i][0]){
                if(visited[i]==false){
                    visit=true;
                    visited[i]=true;
                    dfs(now-dungeon[i][1],count+1);
                    visited[i]=false;
                }

            }
        }
        
        if(visit==false){
            answer=Math.max(answer,count);
        }
    }
}