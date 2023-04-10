class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;
        int zeroCount=0;
        
        while(!s.equals("1")){
            while(s.contains("0")){
                s=s.replaceFirst("0","");
                zeroCount++;
            }
            
            s=Integer.toBinaryString(s.length());
            cnt++;
        }
        

        
        answer[0]=cnt;
        answer[1]=zeroCount;
        
        return answer;
    }
}