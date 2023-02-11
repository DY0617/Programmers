import java.util.*;

class Solution {
    
    static int[][] key,lock;
    static boolean isEnd=false;
    
    static class Point{
        int x,y;
        Point(int a, int b){
            x=a;
            y=b;
        }
    }
    
    static ArrayList<Point> lockList=new ArrayList<>();
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        this.key=key;
        this.lock=lock;
        
        for(int i=0;i<lock.length;i++){
            for(int j=0;j<lock[i].length;j++){
                if(lock[i][j]==0)
                    lockList.add(new Point(i,j));
            }
        }
        
        if(lockList.isEmpty())
            return true;
        else{
            unlock(key,0);
        
            answer=isEnd;
        
            return answer;
        }
        
        
    }
    
    public static boolean unlock(int[][] nowKey,int count){
        
        
        boolean clear=false;
        
        if(count==4){
            return false;
        }
        
        for(Point point:lockList){
            clear=isTrue(nowKey,point);
            if(clear){
                isEnd=true;
                return true;
            }
        }
        
        
        
        nowKey=getRotate(nowKey);
        
        unlock(nowKey,count+1);
        
        
        return false;
    }
    
    public static boolean isTrue(int[][] nowKey,Point point){
        int x=point.x;
        int y=point.y;
        
        boolean isUnlock=false;
        
        for(int i=0;i<nowKey.length;i++){
            for(int j=0;j<nowKey[i].length;j++){
                if(key[i][j]==1){
                    isUnlock=check(nowKey,i,j,x,y);
                    if(isUnlock)
                        return true;
                }
            }
        }
        
        return isUnlock;
    }
    
    public static boolean check(int[][] nowKey,int x,int y,int xloc,int yloc){    
        
        int[][] board=new int[lock.length][lock[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=lock[i][j];
            }
        }
        

        
        for(int i=0;i<nowKey.length;i++){
            for(int j=0;j<nowKey[i].length;j++){
                if(nowKey[i][j]==1){
                    if(0<=xloc+i-x&&xloc+i-x<board.length
                    &&0<=yloc+j-y&&yloc+j-y<board.length){
                        board[xloc+i-x][yloc+j-y]++;
                        if(board[xloc+i-x][yloc+j-y]!=1)
                            return false;
                    }
                }
            }
        }
        
        
        for(Point point:lockList){
            if(board[point.x][point.y]!=1){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static int[][] getRotate(int[][] arr) {
        int[][] resultArr = new int[arr.length][arr.length];
        for (int i = 0; i < resultArr.length; i++) {
            int tempIdx = resultArr.length - 1;
            for (int j = 0; j < resultArr.length; j++) {
                resultArr[i][j] = arr[tempIdx--][i];
            }
        }
        return resultArr;
    }

}