import java.util.*;

class Solution {
    
    static char[] arr;
    static int possible;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int a=0;a<numbers.length;a++){
            long now=numbers[a];

            
            String binary=Long.toBinaryString(now);
            
            int j = 0;
        	while((int)Math.pow(2, j)-1 < binary.length()) {
        		j++;
        	}
            
        	while((int)Math.pow(2, j)-1 != binary.length()) {
        		binary = "0"+ binary;
        	}

            arr=new char[binary.length()];
            
            for(int i=0;i<arr.length;i++){
                arr[i]=binary.charAt(i);
            }
            
            possible=1;
            dfs(0,arr.length-1);
            
            answer[a]=possible;
        }
        
        return answer;
    }
    
    
    public static void dfs(int start,int end){
        int mid=(start+end)/2;       
        
        if(arr[mid]=='0'&&(arr[(start+mid-1)/2]=='1'||arr[(mid+1+end)/2]=='1')){

            possible=0;
            return;
        }
        if(mid-start>1){
            dfs(start,mid-1);
            dfs(mid+1,end);
        }
        else
            return;
        
    }
}