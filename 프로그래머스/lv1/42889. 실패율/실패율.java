import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] stageCount=new int[501];
        int population=stages.length;
        
              
        Arrays.sort(stages);
        
        for(int now:stages)
            if(now<=500)
                stageCount[now]++;
        
        class Fail{
            int idx;
            double failPercent;
            Fail(int a,double b){
                idx=a;
                failPercent=b;
            }
        }
        
        ArrayList<Fail> list=new ArrayList<>();
        
        int idx=0;
        
        for(int i=1;i<=N;i++){
            if(population!=0){
                double nowP=(double)stageCount[i]/population;
                population-=stageCount[i];
                list.add(new Fail(i,nowP));
            }
            else{
                list.add(new Fail(i,0));
            }
            
        }
        
        Collections.sort(list,(o1,o2)->Double.compare(o2.failPercent,o1.failPercent));
        
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i).idx;
        }
        
        
        
        return answer;
    }
}