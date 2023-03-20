import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer,1);
        
        for(int i=0;i<answer.length;i++){
            String[] str=places[i];
            
            for(int j=0;j<str.length;j++){
                for(int k=0;k<str[j].length();k++){
                    if(str[j].charAt(k)=='P'){
                        if(0<=j-2&&j-2<=4&&0<=k&&k<=4){
                            if(str[j-2].charAt(k)=='P'){
                                if(str[j-1].charAt(k)!='X'){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j-1&&j-1<=4&&0<=k&&k<=4){
                            if(str[j-1].charAt(k)=='P'){
                                System.out.println(i+" "+j+" "+k);
                                answer[i]=0;
                                break;
                            }
                        }
                        if(0<=j+1&&j+1<=4&&0<=k&&k<=4){
                            if(str[j+1].charAt(k)=='P'){
                                System.out.println(i+" "+j+" "+k);
                                answer[i]=0;
                                break;
                            }
                        }
                        if(0<=j+2&&j+2<=4&&0<=k&&k<=4){
                            if(str[j+2].charAt(k)=='P'){
                                if(str[j+1].charAt(k)!='X'){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j&&j<=4&&0<=k-2&&k-2<=4){
                            if(str[j].charAt(k-2)=='P'){
                                if(str[j].charAt(k-1)!='X'){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j&&j<=4&&0<=k-1&&k-1<=4){
                            if(str[j].charAt(k-1)=='P'){
                                System.out.println(i+" "+j+" "+k);
                                answer[i]=0;
                                break;
                            }
                        }
                        if(0<=j&&j<=4&&0<=k+1&&k+1<=4){
                            if(str[j].charAt(k+1)=='P'){
                                System.out.println(i+" "+j+" "+k);
                                answer[i]=0;
                                break;
                            }
                        }
                        if(0<=j&&j<=4&&0<=k+2&&k+2<=4){
                            if(str[j].charAt(k+2)=='P'){
                                if(str[j].charAt(k+1)!='X'){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j+1&&j+1<=4&&0<=k+1&&k+1<=4){
                            if(str[j+1].charAt(k+1)=='P'){
                                if(!(str[j+1].charAt(k)=='X'&&str[j].charAt(k+1)=='X')){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j+1&&j+1<=4&&0<=k-1&&k-1<=4){
                            if(str[j+1].charAt(k-1)=='P'){
                                if(!(str[j+1].charAt(k)=='X'&&str[j].charAt(k-1)=='X')){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j-1&&j-1<=4&&0<=k+1&&k+1<=4){
                            if(str[j-1].charAt(k+1)=='P'){
                                if(!(str[j-1].charAt(k)=='X'&&str[j].charAt(k+1)=='X')){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                        if(0<=j-1&&j-1<=4&&0<=k-1&&k-1<=4){
                            if(str[j-1].charAt(k-1)=='P'){
                                if(!(str[j-1].charAt(k)=='X'&&str[j].charAt(k-1)=='X')){
                                    System.out.println(i+" "+j+" "+k);
                                    answer[i]=0;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            
        }
        
        return answer;
    }
}