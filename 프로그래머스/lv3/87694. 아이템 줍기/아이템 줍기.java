import java.util.*;


class Solution {
    
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    static int[][] maps=new int[300][300];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        
        for(int i=0;i<rectangle.length;i++){
            int x1=rectangle[i][0];
            int y1=rectangle[i][1];
            int x2=rectangle[i][2];
            int y2=rectangle[i][3];
            
            for(int j=x1*2;j<=x2*2;j++){
                    maps[j][y1*2]=1;
                    maps[j][y2*2]=1;
            }
            for(int j=y1*2;j<=y2*2;j++){
                    maps[x1*2][j]=1;
                    maps[x2*2][j]=1;
            }
            
        }
        
        for(int i=0;i<rectangle.length;i++){
            int x1=rectangle[i][0];
            int y1=rectangle[i][1];
            int x2=rectangle[i][2];
            int y2=rectangle[i][3];
            
            for(int a=x1*2+1;a<x2*2;a++){
                for(int b=y1*2+1;b<y2*2;b++){
                    maps[a][b]=-1;
                }
            }
            
        }
        

        int x=characterX*2;
        int y=characterY*2;
        
        int locX=itemX*2;
        int locY=itemY*2;
        
        class Point{
            int x, y, count;
            Point(int a, int b,int c){
                x=a;
                y=b;
                count=c;
            }
        }
        
        Queue<Point> q=new LinkedList<>();
        
        q.add(new Point(x,y,0));
        maps[x][y]=0;

        
        while(!q.isEmpty()){
            Point now=q.poll();
            
            if(now.x==locX&&now.y==locY){
                answer=now.count/2;
                break;
            }
            
            
            for(int i=0;i<4;i++){
                if(maps[now.x+dx[i]][now.y+dy[i]]==1){
                    maps[now.x+dx[i]][now.y+dy[i]]=0;
                    q.add(new Point(now.x+dx[i],now.y+dy[i],now.count+1));
                }
            }

            
        }
        
        return answer;
    }
}