import java.util.*;

class Solution {
    private int n;
    private int[][] board;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};
    private final int[] rdx = {-1, 1, 1, -1};
    private final int[] rdy = {1, 1, -1, -1};

    public int solution(int[][] board) {
        this.board = board;
        this.n = board.length;

        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(0, 0, 0, 0)); // 초기 로봇 위치
        boolean[][][] visit = new boolean[n][n][4];
        visit[0][0][0] = true;

        return bfs(queue, visit);
    }

    private int bfs(Queue<Robot> queue, boolean[][][] visit) {
        int x, y, dir, time, ox, oy; // Queue에서 꺼낸 로봇의 x, y, 방향, 시간, 다른 x, y
        int nx, ny, nox, noy, ndir; // 로봇이 이동 후 가지게 되는 위치 및 방향 (nox : next other x)
        int rx, ry; // 회전할 때 판단해야 할 벽의 위치

        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            x = robot.x;
            y = robot.y;
            dir = robot.dir;
            time = robot.time;
            ox = robot.getOtherX();
            oy = robot.getOtherY();

            if (isFinish(x, y) || isFinish(ox, oy)) return time; // 도착하면 리턴

            for (int i = 0; i < 4; i++) { // 상하좌우 이동
                nx = x + dx[i];
                ny = y + dy[i];
                nox = ox + dx[i];
                noy = oy + dy[i];

                if (!isValid(nx, ny) || !isValid(nox, noy)) continue; // 벽 밖으로 나갔는지 체크
                if (board[nx][ny] == 1 || board[nox][noy] == 1) continue; // 벽인지 체크
                if (visit[nx][ny][dir]) continue; // 이미 방문한 곳인지 체크

                visit[nx][ny][dir] = true;
                queue.add(new Robot(nx, ny, dir, time + 1));
            }

            for (int i = 1; i < 4; i += 2) { // x, y를 기준으로 90도 회전
                ndir = (dir + i) % 4;
                nox = x + dx[ndir];
                noy = y + dy[ndir];

                int tempDir = (i == 1) ? ndir : dir;
                rx = x + rdx[tempDir];
                ry = y + rdy[tempDir];

                if (!isValid(nox, noy) || !isValid(rx, ry)) continue;
                if (board[nox][noy] == 1 || board[rx][ry] == 1) continue;
                if (visit[x][y][ndir]) continue;

                visit[x][y][ndir] = true;
                queue.add(new Robot(x, y, ndir, time + 1));
            }

            dir = (dir + 2) % 4; // 방향 반대 처리
            for (int i = 1; i < 4; i += 2) { // ox, oy를 기준으로 90도 회전
                ndir = (dir + i) % 4;
                nx = ox + dx[ndir];
                ny = oy + dy[ndir];

                int tempDir = (i == 1) ? ndir : dir;
                rx = ox + rdx[tempDir];
                ry = oy + rdy[tempDir];

                ndir = (ndir + 2) % 4;
                if (!isValid(nx, ny) || !isValid(rx, ry)) continue;
                if (board[nx][ny] == 1 || board[rx][ry] == 1) continue;
                if (visit[nx][ny][ndir]) continue;

                visit[nx][ny][ndir] = true;
                queue.add(new Robot(nx, ny, ndir, time + 1));
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y) { // 맵 밖으로 나갔는지 체크
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private boolean isFinish(int x, int y) {
        return x == n - 1 && y == n - 1;
    }

    private class Robot {
        int x, y;
        int dir;
        int time;

        Robot(int x, int y, int dir, int time) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.time = time;
        }

        public int getOtherX() {
            return x + dx[dir];
        }

        public int getOtherY() {
            return y + dy[dir];
        }

        @Override
        public String toString() {
            return "time:" + time + "  (" + x + "," + y + ") (" + getOtherX() + "," + getOtherY() + ") dir:" + dir;
        }
    }
}