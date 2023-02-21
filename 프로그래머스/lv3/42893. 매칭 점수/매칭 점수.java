import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    private HashMap<String, Page> map = new HashMap<>();

    public int solution(String word, String[] pages) {
        int idx = 0;
        for (String html : pages) {
            Page page = new Page(idx++, html.toLowerCase());
            page.setDefaultScore(word.toLowerCase());
            page.setLinkCount();
            map.put(page.url, page);
        }

        for (Page page : map.values()) {
            page.setLinkScore();
        }

        ArrayList<Page> list = new ArrayList(map.values());
        Collections.sort(list);

        return list.get(0).idx;
    }

    class Page implements Comparable<Page> {
        int idx;
        int defaultScore = 0;
        int linkCount = 0;
        double linkScore = 0;
        String html, url;

        Page(int idx, String html) {
            this.idx = idx;
            this.html = html;
            findUrl();
        }

        private void findUrl() {
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                url = matcher.group(1);
            }
        }

        public void setDefaultScore(String word) {
            int idx = html.indexOf(word);
            while (idx != -1) {
                char pre = html.charAt(idx - 1);
                char post = html.charAt(idx + word.length());

                if (!Character.isLowerCase(pre) && !Character.isLowerCase(post)) {
                    defaultScore++;
                }
                idx = html.indexOf(word, idx + 1);
            }
        }

        public void setLinkCount() {
            int idx = html.indexOf("<a href=");
            while (idx != -1) {
                linkCount++;
                idx = html.indexOf("<a href=", idx + 1);
            }
        }

        public void setLinkScore() {
            Pattern pattern = Pattern.compile("<a href=\"https://(.+?)\">");
            Matcher matcher = pattern.matcher(html);
            while (matcher.find()) {
                String externalUrl = matcher.group(1);
                if (map.containsKey(externalUrl)) {
                    map.get(externalUrl).linkScore += (double) defaultScore / linkCount;
                }
            }
        }

        @Override
        public int compareTo(Page other) {
            double a = (double) this.defaultScore + this.linkScore;
            double b = (double) other.defaultScore + other.linkScore;

            return Double.compare(b, a);
        }
    }
}