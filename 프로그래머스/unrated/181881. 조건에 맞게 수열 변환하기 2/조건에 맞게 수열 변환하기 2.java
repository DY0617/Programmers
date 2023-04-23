import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int cnt=0;
        int[] lastArr=new int[arr.length];
        
        while(true){
            for(int i=0;i<arr.length;i++){
                lastArr[i]=arr[i];
            }
            
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2==0&&arr[i]>=50){
                    arr[i]=arr[i]/2;
                }
                else if(arr[i]%2==1&&arr[i]<50){
                    arr[i]=arr[i]*2+1;
                }
                
                
                //System.out.print(arr[i]+" ");
            }
            
            boolean istrue=true;
            
            for(int i=0;i<arr.length;i++){
                if(lastArr[i]!=arr[i]){
                    istrue=false;
                    break;
                }
            }
            
            if(istrue){
                break;
            }
            
            cnt++;
        }
        
        return cnt;
    }
}