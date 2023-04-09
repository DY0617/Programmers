class Solution {
    public String[] solution(String[] s) {
        String[] ret = new String[s.length];
        for(int i=0 ; i<s.length ; i++) {
        	ret[i] = helper(s[i]);
        }
        return ret;
    }
    public String helper(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder plus = new StringBuilder();
		
		for(int i=0 ; i<s.length() ; i++) {
			char c = s.charAt(i);
			sb.append(c);
			if(sb.length()>=3 && sb.charAt(sb.length()-3)=='1' && sb.charAt(sb.length()-2)=='1'  && sb.charAt(sb.length()-1)=='0') {
				plus.append("110");
				sb.delete(sb.length()-3, sb.length());
			}
		}
		if(plus.length()>0) {
			if(sb.indexOf("0")==-1) {
				sb.insert(0,plus);
			} else {
				sb.insert(sb.lastIndexOf("0")+1,plus);
			}
		}
		return sb.toString();
	}
}