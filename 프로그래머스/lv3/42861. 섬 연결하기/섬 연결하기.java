import java.util.*;

class Solution {

    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        

        Arrays.sort(costs,(o1,o2)->o1[2]-o2[2]);
        
        parents=new int[n];
        
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        
        for(int i=0;i<costs.length;i++){
            int x=find(costs[i][0]);
            int y=find(costs[i][1]);
            if(x!=y){
                parents[y]=x;
                answer+=costs[i][2];
            }
        }
        
        
        
        
        return answer;
    }
    
    static int find(int x){
        if(parents[x]==x)
            return x;
        return parents[x]=find(parents[x]);
    }
    
}