import java.util.*;



class Solution {
    
    static ArrayList<Integer> list;
    static String number;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        list=new ArrayList<>();
        
        visited=new boolean[numbers.length()];
        number=numbers;
        
        dfs("",0);
        
        answer=list.size();
        
        return answer;
    }
    
    public static boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
    
    public static void dfs(String str,int idx){
        
        int now=0;
        
        if(!str.equals("")){
            now=Integer.parseInt(str);
            if(!list.contains(now)){
                if(isPrime(now)){
                    list.add(now); 
                }

            }
        }
        
        if(idx==number.length())
            return;
        

        for(int i=0;i<number.length();i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(str+number.charAt(i), idx+1);
            visited[i] = false;
        }
        
    }
    
}

