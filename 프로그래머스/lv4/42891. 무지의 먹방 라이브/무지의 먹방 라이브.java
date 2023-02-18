import java.util.*;

class Solution {
    public class Food {
        private int index;
        private int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public int solution(int[] food_times, long k) {
        int answer = 0;
        long max = 0;
        long size = food_times.length;
        int index = 1;

        PriorityQueue<Food> queue = new PriorityQueue<>((o1,o2)->o1.time-o2.time);

        for (int food_time : food_times) {
            max += food_time;
            queue.add(new Food(index++, food_time));
        }

        if (max <= k) return -1;

        long total = 0;
        long prev = 0;

        while(total + (queue.peek().time - prev) * size <= k) {
            int pick = queue.poll().time;
            total += (pick - prev) * size;
            size--;
            prev = pick;
        }

        ArrayList<Food> list = new ArrayList<>();

        while(!queue.isEmpty()) list.add(queue.poll());

          Collections.sort(list,(o1,o2)->o1.index-o2.index);

        answer = list.get((int)((k-total) % size)).index;

        return answer;
    }
}