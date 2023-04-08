import java.util.*;

class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
 // 0, 1, 2, 3 = {좌, 우, 상, 하}
        int[] point = { y, y + 1, x, x + 1 };
        int[] dir = { -1, 1, -1, 1 };
        int[] boundary = { 0, m, 0, n };
        int[] limit = { m, m, n, n };

        for (int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            int dx = queries[i][1];

            // ReverseQuery => {우, 좌, 하, 상} 으로 움직일 것
            int reverse = command ^ 1; // 0->1, 1->0, 2->3, 3->2
            point[reverse] += dir[reverse] * dx;
            point[reverse] = Math.max(Math.min(point[reverse], limit[reverse]), 0);

            // 현재 위치가 벽에 부딪히지 않았을 때
            if (point[command] != boundary[command]) {
                point[command] += dir[reverse] * dx;
                point[command] = Math.max(Math.min(point[command], limit[command]), 0);
            }

            // 경계를 벗어났을 때
            if (point[0] == m || point[1] == 0 || point[2] == n || point[3] == 0) {
                return 0L;
            }
        }
        return (1L * point[1] - point[0]) * (1L * point[3] - point[2]);

    }
}