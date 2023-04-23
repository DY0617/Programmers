class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        int idx=0;
        int mul=0;
        while(true){
            idx=(mul++)*q+r;
            if(idx>=code.length())
                break;
            
            answer+=String.valueOf(code.charAt(idx));
        }
        return answer;
    }
}