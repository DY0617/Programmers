import java.util.*;
class Solution {
    
Deque<Integer> side1;
Deque<Integer> side2;
Deque<Deque<Integer>> inside;
    public int[][] solution(int[][] rc, String[] operations) {
      
        //첫번째기둥
        side1 = new LinkedList<>();
        //두번째기둥
        side2 = new LinkedList<>();
        //가운데 원소들
        inside = new LinkedList<>();
        
        
        int x = rc[0].length;
        int y = rc.length;
        
        // 맵 분리하기
        for(int i=0;i<y;i++){
            inside.addLast(new LinkedList<>());
            for(int j=0;j<x;j++){
                if(j==0){
                    side1.add(rc[i][j]);
                }
                else if(j==x-1){
                    side2.add(rc[i][j]);
                }
                else{                
                    inside.peekLast().addLast(rc[i][j]);
                }  
            }
        }
        
        // Operation 실시
        for(String o : operations){
            if(o.equals("Rotate")){
                rotate();
            }
            else{
                shift();
            }
        }
        
        int[][] answer = new int[y][x];
     
        
    
        for(int i=0;i<y;i++){
            
            int j=0;
            answer[i][j++]=side1.pollFirst();
            
            for(int e : inside.pollFirst()){
                answer[i][j++]=e;
            }
            
            answer[i][j]=side2.pollFirst();
        }
        
        return answer;
    }
    
    // Shift연산
    public void shift(){
        
       side1.addFirst(side1.removeLast());
       side2.addFirst(side2.removeLast());
       inside.addFirst(inside.removeLast());
    }
    // 회전연산
    public void rotate(){
                
        inside.peekFirst().addFirst(side1.removeFirst());
        side2.addFirst(inside.peekFirst().removeLast());
        inside.peekLast().addLast(side2.removeLast());
        side1.addLast(inside.peekLast().removeFirst());
        
    }
}