import java.util.*;

class Solution {
    int[] nums;
    int max;
    ArrayList<Integer> prime=new ArrayList<>();
    int answer=0;
    public int solution(int[] nums) {
        Arrays.sort(nums);
        this.nums=nums;
        
        max=nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        
        for(int i=2;i<=3000;i++){
            if(isPrime(i)){
                prime.add(i);
            }
        }
        

        dfs(0,0,0);
        


        return answer;
    }
    
    public void dfs(int sum,int depth,int idx){
        if(depth==3){

            if(prime.contains(sum)){
                answer++;
            }
            return;
        }
        

        
        for(int i=idx;i<nums.length;i++){
            dfs(sum+nums[i],depth+1,i+1);
        }
        
    }
    
    public boolean isPrime(int num){
        if(num==0)
            return false;
        if(num==1)
            return false;
        
        for(int i=2;i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}