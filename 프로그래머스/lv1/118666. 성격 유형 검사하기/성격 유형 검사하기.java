import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[][] arr=new int[4][2];
        String[] type={"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};
        int[] score={3,2,1};
        
        for(int a=0;a<survey.length;a++){
            
            String str=survey[a];
            
            int idx=0;
            
            for(int i=0;i<type.length;i++){
                if(type[i].equals(str)){
                    idx=i;
                    break;
                }
            }
            
            int x=idx/2;
            int y=idx%2;
            
            if(choices[a]<=3){
                arr[x][y]+=score[choices[a]-1];
            }
            else if(choices[a]>4){
                if(y==1){
                    y=0;
                }
                else
                    y=1;
                arr[x][y]+=choices[a]-4;
            }
            
        }
        
        for(int i=0;i<4;i++){
            if(arr[i][0]>=arr[i][1]){
                answer=answer+type[i*2].charAt(0);
            }
            else{
                answer=answer+type[i*2+1].charAt(0);
            }
        }
        
        
        return answer;
    }
}