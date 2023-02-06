import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> scoreMap;
    static int score;
    static String[] strings;
    static String[] sInfoArr;

    static void dfs(int lv) {
        if (lv == 4) {
            String str = String.join("", strings);
            if (!scoreMap.containsKey(str))
                scoreMap.put(str, new ArrayList<>());
            scoreMap.get(str).add(score);
        }else {
            strings[lv] = sInfoArr[lv];
            dfs(lv + 1);
            strings[lv] = "-";
            dfs(lv + 1);
        }
    }
    static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public static int[] solution(String[] info, String[] query) {
        scoreMap = new HashMap<>();

        for (String sInfo : info) {
            strings = new String[4];
            sInfoArr = sInfo.split(" ");
            score = Integer.parseInt(sInfoArr[4]);
            dfs(0);
        }

        for (String key : scoreMap.keySet())
            Collections.sort(scoreMap.get(key));

        int idx = 0;
        int[] answer = new int[query.length];
        for (String q : query) {
            String[] strs = q.split(" and | ");
            String key = strs[0] + strs[1] + strs[2] + strs[3];

           if (!scoreMap.containsKey(key))
               answer[idx++] = 0;
           else {
               ArrayList<Integer> ansList = scoreMap.get(key);
               answer[idx++] = ansList.size() - lowerBound(ansList, Integer.parseInt(strs[4]));
           }
        }
        return answer;
    }
}