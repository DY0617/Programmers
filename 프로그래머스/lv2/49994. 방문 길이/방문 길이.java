import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[][][] dir=new int[11][11][4];
        
        int x=5;
        int y=5;
        
        int[] dx={-1,0,1,0};
        int[] dy={0,-1,0,1};
        
        for(int i=0;i<dirs.length();i++){
            char now=dirs.charAt(i);
            
            if(now=='U'){
                if(0<=x+dx[0]&&x+dx[0]<dir.length){
                    if(dir[x][y][0]==0||dir[x-1][y][2]==0){
                        dir[x][y][0]++;
                        dir[x-1][y][2]++;
                        answer++;
                    }
                    x=x+dx[0];
                }
            }
            if(now=='L'){
                if(0<=y+dy[1]&&y+dy[1]<dir.length){
                    if(dir[x][y][1]==0||dir[x][y-1][3]==0){
                        dir[x][y][1]++;
                        dir[x][y-1][3]++;
                        answer++;
                    }
                    y=y+dy[1];
                }
            }
            if(now=='D'){
                if(0<=x+dx[2]&&x+dx[2]<dir.length){
                    if(dir[x][y][2]==0||dir[x+1][y][0]==0){
                    dir[x][y][2]++;
                    dir[x+1][y][0]++;
                    answer++;
                }
                x=x+dx[2];
                }
                
            }
            if(now=='R'){
                if(0<=y+dy[3]&&y+dy[3]<dir.length){
                    if(dir[x][y][3]==0||dir[x][y+1][1]==0){
                    dir[x][y][3]++;
                    dir[x][y+1][1]++;
                    answer++;
                }
                y=y+dy[3];
                }
                
            }
        }
        
        return answer;
    }
}