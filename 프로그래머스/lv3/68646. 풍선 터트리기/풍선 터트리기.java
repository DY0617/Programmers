  class Solution{

public int solution(int[] a) {
        
        if (a.length == 1) {
            return 1;
        }
 
        int answer = 2;                             // 처음과 끝 풍선은 결국 살아남을 수 있으므로
        int minValue = Integer.MAX_VALUE;            // 최솟값
        int[] leftMin = new int[a.length];            // 한 순간에서 왼쪽 부분의 최솟값
        int[] rightMin = new int[a.length];            // 한 순간에서 오른족 부분의 최솟값
        
        for(int i = 0; i < a.length; i++) {
            if(minValue > a[i]) {
                minValue = a[i];
            }
            leftMin[i] = minValue; 
        }
        
        minValue = Integer.MAX_VALUE;            //최솟값 초기화
        
        for(int i = a.length-1; i >= 0; i--) {
            if(minValue > a[i]) {
                minValue = a[i];
            }
            rightMin[i] = minValue; 
        }
        
        for(int i = 1; i < a.length-1; i++) {
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) {    //양 쪽의 최솟값보다 크다면 continue
                continue;
            }
            answer++;
        }
        
        return answer;
   
  }
      
  }