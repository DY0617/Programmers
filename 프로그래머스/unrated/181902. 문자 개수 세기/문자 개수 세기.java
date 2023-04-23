class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        char UpperStart='A';
        char UpperLast='Z';
        char LowerStart='a';
        char LowerLast='z';
        
        for(int i=0;i<my_string.length();i++){
            char nowChar=my_string.charAt(i);
            if(UpperStart<=nowChar&&nowChar<=UpperLast){
                int idx=nowChar-UpperStart;
                answer[idx]++;
            }
            else{
                int idx=nowChar-LowerStart+26;
                answer[idx]++;
            }
        }
        
        return answer;
    }
}