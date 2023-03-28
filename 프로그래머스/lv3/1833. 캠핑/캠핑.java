import java.util.*;

class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        int[][] dp = new int[5000][5000];

        // 좌표 압축
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int[] p : data) {
            xList.add(p[0]);
            yList.add(p[1]);
        }

        ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<Integer>(xList));
        ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<Integer>(yList));

        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);

        for (int i = 0; i < n; i++) {
            data[i][0] = uniqueXList.indexOf(xList.get(i));
            data[i][1] = uniqueYList.indexOf(yList.get(i));

            dp[data[i][1]][data[i][0]] = 1;
        }


        // dp(구간합) 구하기
        for (int r = 0; r < 5000; r++) {
            for (int c = 0; c < 5000; c++) {
                if (r - 1 >= 0) {
                    dp[r][c] += dp[r - 1][c];
                }

                if (c - 1 >= 0) {
                    dp[r][c] += dp[r][c - 1];
                }

                if (r - 1 >= 0 & c - 1 >= 0) {
                    dp[r][c] -= dp[r - 1][c - 1];
                }
            }
        }

        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = Math.min(data[i][0], data[j][0]);
                int y1 = Math.min(data[i][1], data[j][1]);
                int x2 = Math.max(data[i][0], data[j][0]);
                int y2 = Math.max(data[i][1], data[j][1]);

                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                int count = dp[y2 - 1][x2 - 1] - dp[y2 - 1][x1] - 
                			  dp[y1][x2 - 1] + dp[y1][x1];
                              
                if (count == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}