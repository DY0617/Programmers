import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        ArrayList<String> firstGenres = new ArrayList<>();
        while(map.size()!=0){
            int max = Integer.MIN_VALUE;
            String max_key = "";
            for(String key : map.keySet()){
                int tmp_cnt = map.get(key);
                if(tmp_cnt>max){
                    max = tmp_cnt;
                    max_key = key;
                }
            }
            firstGenres.add(max_key);
            map.remove(max_key);
        }
        
        
        class Music{
            String genres;
            int play,idx;
            Music(String a, int b, int c){
                genres=a;
                play=b;
                idx=c;
            }
        }
        
        
        ArrayList<Music> result = new ArrayList<>();
        for(String gern : firstGenres){
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(gern)){
                    list.add(new Music(gern, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size()!=1){
                result.add(list.get(1));
            }
        }
        
        
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).idx;
        }
        
        
        return answer;
    }
}