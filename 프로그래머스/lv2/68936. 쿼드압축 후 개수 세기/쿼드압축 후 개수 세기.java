import java.util.*;

class Solution {
    int oneN=0;
    int zeroN=0;
    int[][] arr;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        this.arr=arr;
        
        dfs(0,0,arr.length-1,arr.length-1);
        
        answer[0]=zeroN;
        answer[1]=oneN;
        
        return answer;
    }
    
    public void dfs(int x1,int y1,int x2,int y2){
        
        int check=arr[x1][y1];
        boolean istrue=true;
        
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                if(check!=arr[i][j]){
                    istrue=false;
                    break;
                }
            }
        }
        
        if(istrue){
            if(check==0){
                zeroN++;
            }
            else
                oneN++;
            

        }
        else{
            /*
            System.out.println(x1+" "+y1+"  "+(x1+x2)/2+"   "+(y1+y2)/2);
            System.out.println(((x1+x2)/2+1)+" "+((y1+y2)/2+1)+"  "+x2+"   "+y2);
            System.out.println(((x1+x2)/2+1)+" "+y1+"  "+x2+"   "+((y1+y2)/2));
            System.out.println(x1+" "+((y1+y2)/2+1)+"  "+((x1+x2)/2)+"   "+y2);
            */
            
            dfs(x1,y1,(x1+x2)/2,(y1+y2)/2);
            dfs((x1+x2)/2+1,(y1+y2)/2+1,x2,y2);
            dfs((x1+x2)/2+1,y1,x2,(y1+y2)/2);
            dfs(x1,(y1+y2)/2+1,(x1+x2)/2,y2);
            
        }
        
        return;
    }
}