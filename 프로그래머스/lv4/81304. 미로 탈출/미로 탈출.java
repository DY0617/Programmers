import java.util.*;

public class Solution {

    private static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int[][] graph = new int[n + 1][n + 1];
        Arrays.stream(graph).forEach(x -> Arrays.fill(x, INF));
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int[] road : roads) {
            graph[road[0]][road[1]] = Math.min(graph[road[0]][road[1]], road[2]);
        }

        // 다익스트라
        boolean[][] visited = new boolean[n + 1][1 << traps.length];

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int state = current.state;

            if (current.number == end) {
                return current.cost;
            }

            if (visited[current.number][current.state]) {
                continue;
            }
            visited[current.number][current.state] = true;

            boolean currentTrapped = false;
            Set<Integer> trapped = new HashSet<>();
            for (int i = 0; i < traps.length; i++) {
                int bit = 1 << i;

                if ((state & bit) != 0) { // 비트에 해당하는 trap이 활성 상태인 경우
                    if (current.number == traps[i]) { // 그 트랩이 현재 노드인 경우
                        state &= ~bit; // state에서 이 trap을 비활성화
                        continue;
                    }

                    trapped.add(traps[i]);
                    continue;
                }

				// 비트에 해당하는 trap이 활성 상태가 아닌 경우
                if (current.number == traps[i]) { // 그 트랩이 현재 노드인 경우
                    state |= bit; // state에서 이 trap을 활성화
                    trapped.add(traps[i]);
                    currentTrapped = true;
                }
            }

            for (int i = 1; i <= n; i++) {
                if (current.number == i) {
                    continue;
                }

                boolean nextTrapped = trapped.contains(i); // 다음 이동할 노드가 trap인지 체크

                if (currentTrapped == nextTrapped) { // 현재 노드, 다음 노드 둘다 트랩이거나, 둘 다 아니거나는 결과가 동일
                    if (graph[current.number][i] != INF) {
                        queue.add(new Node(i, current.cost + graph[current.number][i], state));
                    }
                    continue;
                }

				// 둘 중 하나가 트랩이라면 그래프의 역방향을 적용
                if (graph[i][current.number] != INF) {
                    queue.add(new Node(i, current.cost + graph[i][current.number], state));
                }
            }
        }

        return INF;
    }

    class Node implements Comparable<Node> {
        int number;
        int cost;
        int state;

        public Node(int number, int cost, int state) {
            this.number = number;
            this.cost = cost;
            this.state = state;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}