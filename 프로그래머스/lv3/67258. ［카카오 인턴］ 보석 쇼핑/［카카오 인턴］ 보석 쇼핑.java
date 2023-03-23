import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, L = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int R = 0; R < gems.length; R++) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);

            while (map.get(gems[L]) > 1) {
                map.put(gems[L], map.get(gems[L]) - 1);
                L++;
            }

            if (map.size() == kind && length > (R - L)) {
                length = R - L;
                answer[0] = L + 1;
                answer[1] = R + 1;
            }
        }

        return answer;
    }
}