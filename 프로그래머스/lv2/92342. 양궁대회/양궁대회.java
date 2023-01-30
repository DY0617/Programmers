import java.util.*;

class Solution {
    static int[] info;
    static int n;
    static int max=0;
    static int[] answer;
    public int[] solution(int n, int[] info) {
        this.info=info;
        this.n=n;
        
        answer=new int[11];
        
        for(int i=0;i<info.length/2;i++){
            int tmp=info[i];
            info[i]=info[info.length-1-i];
            info[info.length-1-i]=tmp;
        }
        
        
        int a=0;
        for(int i=0;i<info.length;i++){
            if(info[i]!=0){
                a+=i;
            }
        }
        
        
        int[] arrow=new int[11];
        
        
        dfs(arrow,0,10,0,a);
        
        if(max==0){
            answer=new int[1];
            answer[0]=-1;
        }
        
        return answer;
    }
    
    static void dfs(int[] arr,int depth,int target,int total,int apitch){

        if(target==-1){
            if(depth==n){
                if(max<=(total-apitch)){
                    
                    
                    boolean isSame=false;
                    if(max==(total-apitch)){
                        isSame=true;
                    }
                    
                    max=total-apitch;
                    
                    if(isSame){
                    boolean priority=false;
                    
                    for(int i=0;i<arr.length;i++){
                        if(answer[10-i]==arr[i]) 
                            continue;
                        else if(answer[10-i]<arr[i]){
                            priority=true;
                        }
                        else{
                            break;
                        }

                    }
                    
 
                        
                    if(priority){
                        for(int i=0;i<arr.length;i++){
                            answer[i]=arr[10-i];
                        }
                    }
                    }
                    else{
                        for(int i=0;i<arr.length;i++){
                            answer[i]=arr[10-i];
                        }
                    }
                    
                }
            }
            return;
        }
        

        

        dfs(arr,depth,target-1,total,apitch);

        if(target==0){
            if(n>depth){
                int last=n-depth;
                depth=n;
                arr[target]=last;
                dfs(arr,n,target-1,total,apitch);
            }
        }
        
        depth+=info[target]+1;
        arr[target]=info[target]+1;
        if(n>=depth){
            if(info[target]==0)
                dfs(arr,depth,target-1,total+target,apitch);
            else{
                dfs(arr,depth,target-1,total+target,apitch-target);
            }

        }


        arr[target]=0;
        return;
    }
    
}