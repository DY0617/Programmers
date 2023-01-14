import java.util.*;

class Solution {
    public int solution(int[] money) {
        int[] dp_first = new int[money.length];
        int[] dp_second = new int[money.length];
        
        for(int i = 0; i < money.length; i++) {
            dp_first[i] = money[i];
            dp_second[i] = money[i];
        }
        dp_first[1] = -1;
        dp_second[0] = -1;
        dp_first[2] += dp_first[0];
        for (int i = 3; i < money.length; i++) {
            dp_first[i] += Math.max(dp_first[i - 2], dp_first[i - 3]);
            dp_second[i] += Math.max(dp_second[i - 2], dp_second[i - 3]);
        }
        int first_max = Math.max(dp_first[money.length - 2], dp_first[money.length - 3]);
        int second_max = Math.max(dp_second[money.length - 1], dp_second[money.length - 2]);
        return Math.max(first_max, second_max);
    }
}