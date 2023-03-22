import java.util.*;

class Solution {
    class Point{
            int x,y;
            Point(int a, int b){
                x=a;
                y=b;
            }
        }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        char[][] charPad={
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'},
            {'*','0','#'}
        };
        
        
        
        Map<Character,Point> pad=new HashMap<>();
        
        for(int i=0;i<charPad.length;i++){
            for(int j=0;j<charPad[i].length;j++){
                pad.put(charPad[i][j],new Point(i,j));
            }
        }
        
        Point left=new Point(3,0);
        Point right=new Point(3,2);
        
        for(int nowNum:numbers){
            char loc=Character.forDigit(nowNum , 10);
            Point nowPoint=pad.get(loc);
            
            if(nowPoint.y==0){
                answer+="L";
                left=nowPoint;
            }
            else if(nowPoint.y==2){
                answer+="R";
                right=nowPoint;
            }
            else{
                int closer=distance(left,right,nowPoint);
            if(closer==1){
                answer+="L";
                left=nowPoint;
            }
            else if(closer==-1){
                answer+="R";
                right=nowPoint;
            }
            else{
                if(hand.equals("left")){
                    answer+="L";
                    left=nowPoint;
                }
                else{
                    answer+="R";
                    right=nowPoint;
                }
            }
            }
            
            
            
        }
        
        
        
        return answer;
    }
    
    public int distance(Point left,Point right,Point location){
        int leftDis=Math.abs(left.x-location.x)+Math.abs(left.y-location.y);
        int rightDis=Math.abs(right.x-location.x)+Math.abs(right.y-location.y);
        if(leftDis<rightDis){
            return 1;
        }
        else if(leftDis==rightDis)
            return 0;
        else
            return -1;
    }
}