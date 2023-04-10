import java.util.*;

class Solution {

        long answer;
        boolean[] visited;
        long[] long_a;
        ArrayList<Integer>[] children;

        public long solution(int[] a, int[][] edges) {
            this.answer = 0;
            this.visited = new boolean[a.length];
            this.children = new ArrayList[a.length];
            this.long_a = new long[a.length];

            long sum = 0;
            for(int i = 0; i < a.length; i++){
                sum += a[i];
                children[i] = new ArrayList<>();
                long_a[i] = a[i];
            }

            if(sum != 0) return -1;

            for(int i = 0 ; i < edges.length; i++){
                children[edges[i][0]].add(edges[i][1]);
                children[edges[i][1]].add(edges[i][0]);
            }

            dfs(0);

            return answer;
        }

        public long dfs(int v){
            this.visited[v] = true;
            
            for(int i = 0; i < children[v].size(); i++){
                int next = children[v].get(i);
                if(!visited[next]){
                    long_a[v] += dfs(next);
                }
            }

            this.answer += Math.abs(long_a[v]);

            return long_a[v];
        }

    }