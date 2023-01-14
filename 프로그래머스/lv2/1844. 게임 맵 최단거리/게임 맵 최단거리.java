import java.util.*;

class Solution {
    static int n,m;
    static int[][] map;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int answer;
    public int solution(int[][] maps) {
        map=maps;
        n=map.length-1;
        m=map[0].length-1;
        answer = 0;
        
        class Point{
            int x, y,depth;
            Point(int x,int y,int depth){
                this.x=x;
                this.y=y;
                this.depth=depth;
            }
        }
        
        Queue<Point> q=new LinkedList<>();
        
        q.add(new Point(0,0,1));
        
        
        while(!q.isEmpty()){
            Point now=q.remove();
            
            if(now.x==n&&now.y==m){
                answer=now.depth;
                break;
            }
            
            
            
            if(now.x<n&&map[now.x+dx[0]][now.y+dy[0]]==1){
                q.add(new Point(now.x+dx[0],now.y+dy[0],now.depth+1));
                map[now.x+dx[0]][now.y+dy[0]]=0;
            }
            if(now.y<m&&map[now.x+dx[1]][now.y+dy[1]]==1){
                q.add(new Point(now.x+dx[1],now.y+dy[1],now.depth+1));
                map[now.x+dx[1]][now.y+dy[1]]=0;
            }
            if(now.x>0&&map[now.x+dx[2]][now.y+dy[2]]==1){
                q.add(new Point(now.x+dx[2],now.y+dy[2],now.depth+1));
                map[now.x+dx[2]][now.y+dy[2]]=0;
            }
            if(now.y>0&&map[now.x+dx[3]][now.y+dy[3]]==1){
                q.add(new Point(now.x+dx[3],now.y+dy[3],now.depth+1));
                map[now.x+dx[3]][now.y+dy[3]]=0;
            }
            
        }
        
        if(answer==0)
            answer=-1;
        
        return answer;
    }
    
    
}