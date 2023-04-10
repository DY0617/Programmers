class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s=Integer.toString(n,3);
        
        StringBuilder sb=new StringBuilder();
        
        sb.append(s);
        sb.reverse();
        
        s=sb.toString();
        
        s=Integer.toString(Integer.parseInt(s,3));
        
        
        return Integer.parseInt(s);
    }
}