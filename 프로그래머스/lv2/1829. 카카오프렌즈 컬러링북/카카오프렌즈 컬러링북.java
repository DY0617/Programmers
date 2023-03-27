import java.util.*;

class Solution {
    
    int m,n;
    boolean[][] visited;
    int[][] picture;
    
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    
    int[] dx={1,-1,0,0};
    int[] dy={0,0,1,-1};
    
    int nowSize;
    
    public int[] solution(int m, int n, int[][] picture) {
        
        int k;

        this.m=m;
        this.n=n;
        this.picture=picture;
        
        
        visited=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j]!=0&&!visited[i][j]){
                    nowSize=0;
                    visited[i][j]=true;
                    dfs(i,j,picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,nowSize);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        System.out.println(numberOfArea);
        
        return answer;
    }
    
    public void dfs(int x,int y,int baseNum){
        nowSize++;
        for(int i=0;i<4;i++){
            if(0<=x+dx[i]&&x+dx[i]<m&&0<=y+dy[i]&&y+dy[i]<n){
                if(!visited[x+dx[i]][y+dy[i]]&&
                   picture[x+dx[i]][y+dy[i]]==baseNum){
                    visited[x+dx[i]][y+dy[i]]=true;
                    dfs(x+dx[i],y+dy[i],baseNum);
                }
            }
        }
        
        
        
        return;
    }
}