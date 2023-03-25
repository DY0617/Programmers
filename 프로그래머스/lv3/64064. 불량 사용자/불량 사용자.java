import java.util.*;

class Solution {
    static HashSet<HashSet<String>> answer;
    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);

        return answer.size();
    }


    private static void dfs(HashSet<String> hs, String[] user_id, String[] banned_id) {
        if (hs.size() == banned_id.length) {
            if (isBanList(hs, banned_id)) {
                answer.add(new HashSet<>(hs));
            }
            return;
        }

        for (String userId : user_id) {
            if (hs.add(userId)) {
                dfs(hs, user_id, banned_id);
                hs.remove(userId);
            }
        }
    }


    private static boolean isBanList(HashSet<String> hs, String[] banned_id) {
        int idx = 0;
        for (String userID : hs) {
            String banID = banned_id[idx++];
            if (userID.length() != banID.length()) {
                return false;
            }
            for (int i = 0; i < banID.length(); i++) {
                if (banID.charAt(i) == '*') {
                    continue;
                }
                if (userID.charAt(i) != banID.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}