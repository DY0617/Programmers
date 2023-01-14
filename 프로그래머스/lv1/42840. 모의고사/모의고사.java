import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] m1={1,2,3,4,5};
        int[] m2={2,1,2,3,2,4,2,5};
        int[] m3={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int count1=0;
        int count2=0;
        int count3=0;
        
        for(int i=0;i<answers.length;i++){
            int now=answers[i];
            if(now==m1[i%5])
                count1++;
                        
            if(now==m2[i%8])
                count2++;
            
                        
            if(now==m3[i%10])
                count3++;
            
        }
        
        int max = Math.max(Math.max(count1, count2),count3);
        System.out.println(max);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==count1) list.add(1); 
        if(max==count2) list.add(2);
        if(max==count3) list.add(3);
        
        answer = new int[list.size()];
        
        for(int i =0; i<answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}