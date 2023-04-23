class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        
        StringBuilder sb;
        
        for(int i=0;i<picture.length;i++){
            sb=new StringBuilder();
            String str=picture[i];
            for(int p=0;p<str.length();p++){
                String now=String.valueOf(str.charAt(p));
                int cnt=0;
                while(cnt<k){
                    cnt++;
                    sb.append(now);
                }
            }
            int cnt=0;
            for(int p=i*k;p<i*k+k;p++)
                answer[p]=sb.toString();
        }
        
        return answer;
    }
}