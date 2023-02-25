import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        class Point{
            int x,y;
            Point(int x,int y){
                this.x=x;
                this.y=y;
            }
        }
        
        ArrayList<Point> removeList;
        
        String[][] map=new String[board.length][board[0].length()];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                map[i][j]=String.valueOf(board[i].charAt(j));
            }
        }
        
        while(true){
            
            removeList=new ArrayList<>();
            
            for(int i=board.length-1;i>=0;i--){
                for(int j=0;j<board[i].length()-1;j++){
                    if(map[i][j].equals(map[i][j+1])&&!map[i][j].equals("")){
                        if(i!=0){
                            String same=map[i][j];
                            if(map[i-1][j].equals(map[i-1][j+1])&&map[i-1][j].equals(same)){
                                removeList.add(new Point(i,j));
                            }
                        }
                    }
                }
            }
            
            
            if(removeList.size()==0)
                break;
            else{
                
                
                Set<Integer> set=new HashSet<>();
                
                for(Point point:removeList){
                    
                    if(!map[point.x][point.y].equals("")){
                        map[point.x][point.y]="";
                        answer++;
                    }
                    if(!map[point.x-1][point.y].equals("")){
                        map[point.x-1][point.y]="";
                        answer++;
                    }
                    if(!map[point.x][point.y+1].equals("")){
                        map[point.x][point.y+1]="";
                        answer++;
                    }
                    if(!map[point.x-1][point.y+1].equals("")){
                        map[point.x-1][point.y+1]="";
                        answer++;
                    }
                    
                    set.add(point.y);
                    set.add(point.y+1);
                }        
                
                for(int now:set){
                    int x=-1;
                    
                    for(int i=board.length-1;i>=0;i--){
                        if(map[i][now].equals("")){
                            x=Math.max(x,i);
                            continue;
                        }
                        
                        if(x!=-1){
                            map[x][now]=map[i][now];
                            map[i][now]="";
                            x--;
                        }
                        
                    }
                    
                }
                
            }
          
         /*   
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
            */
            
        }
        
        
        return answer;
    }
}