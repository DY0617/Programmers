class Solution {
    public int solution(int[] a) {
        int answer = 0;
 
        int[] count = new int[a.length + 1]; // a길이 미만의 수
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
 
        for (int i = 0; i<count.length; i++) {
            if(count[i]==0) continue;
            if (count[i] <= answer) continue;
            int star = 0;
           for(int j=0 ; j<a.length-1 ; j++) {
        		if(a[j]!=i && a[j+1]!=i) continue;
        		if(a[j]==a[j+1]) continue;
        		star++;
        		j++;
        	}
            answer = Math.max(answer, star); // 스타 수열 최대값
        }
        return answer*2;
    }
}