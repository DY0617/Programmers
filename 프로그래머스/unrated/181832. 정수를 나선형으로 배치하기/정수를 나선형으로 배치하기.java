import java.util.*;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for(int i=0;i<answer.length;i++)
            Arrays.fill(answer[i],-1);
        
        int x=0;
        int y=0;
        
        int cnt=1;
        
        int dir=0;
        
        while(cnt<=n*n){
            if(dir==0){
                if(0<=x&&x<n&&0<=y+1&&y+1<n){
                    if(answer[x][y+1]==-1)
                        answer[x][y++]=cnt++;
                    else
                        dir=1;
                }
                else{
                    dir=1;
                }
            }
            else if(dir==1){
                if(0<=x+1&&x+1<n&&0<=y&&y<n){
                    if(answer[x+1][y]==-1)
                        answer[x++][y]=cnt++;
                    else
                        dir=2;
                }
                else{
                    dir=2;
                }
            }
            else if(dir==2){
                if(0<=x&&x<n&&0<=y-1&&y-1<n){
                    if(answer[x][y-1]==-1)
                        answer[x][y--]=cnt++;
                    else
                        dir=3;
                }
                else{
                    dir=3;
                }
            }
            else{
                if(0<=x-1&&x-1<n&&0<=y&&y<n){
                    if(answer[x-1][y]==-1)
                        answer[x--][y]=cnt++;
                    else
                        dir=0;
                }
                else{
                    dir=0;
                }
            }
            
            
            if(cnt==n*n){
                answer[x][y]=cnt++;
                break;
            }
                
        }
        
        
        
        return answer;
    }
}