class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            String nowBit=Long.toBinaryString(numbers[i]);
            long idx=numbers[i]+1;
            
            if(numbers[i]%2==0){
                answer[i]=idx;
                continue;
            }
            
            int zeroidx=nowBit.lastIndexOf("0");
            if(zeroidx!=-1){
                nowBit=nowBit.substring(0,zeroidx)+"10"+nowBit.substring(zeroidx+2,nowBit.length());
                answer[i]=Long.parseLong(nowBit,2);
            }
            else{
                nowBit="10"+nowBit.substring(1,nowBit.length());
                answer[i]=Long.parseLong(nowBit,2);
            }
            
        }
        
        return answer;
    }
}