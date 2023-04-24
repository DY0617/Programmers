import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        class Rank{
            int idx,rank;
            Rank(int a,int b){
                idx=a;
                rank=b;
            }
        }
        
        ArrayList<Rank> list=new ArrayList<>();
        
        for(int i=0;i<rank.length;i++){
            if(attendance[i])
                list.add(new Rank(i,rank[i]));
        }
        
        Collections.sort(list,(o1,o2)->o1.rank-o2.rank);
        
        answer=list.get(0).idx*10000+list.get(1).idx*100+list.get(2).idx;
        
        return answer;
    }
}