import java.util.*;

class Solution {
    static int eNum, uNum;
    static int[] rates = {40,30,20,10}; 
    static int[] discounts, emoticons;
    static int[][] users;
    static int[] ans = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};

        //users 100
        //emoticons 7
        //완전탐색 백트랙킹
        this.users = users;
        this.emoticons = emoticons;
        eNum = emoticons.length;
        discounts = new int[eNum];
        uNum = users.length;

        setDiscount(0);

        return ans;
    }
    //idx: 현재 할인율을 설정할 이모티콘의 인덱스
    public static void setDiscount(int idx){
        if(idx==eNum){
            //구한다.
            int totalPlus = 0;
            int totalEmo = 0;
            for(int u=0; u<uNum; u++){
                int uCost = 0;
                for(int e=0; e<eNum; e++){
                    //유저는 이모티콘의 할인율이 자신이 설정한 값 이상이면 구매한다.
                    if(discounts[e]>=users[u][0]){
                        uCost += emoticons[e]*(100-discounts[e])*0.01;
                    }
                }
                //최종적인 이모티콘 플러스 구매 여부
                if(uCost>=users[u][1]){
                    totalPlus ++;;
                } else{
                    totalEmo += uCost;
                }

            }
            //정답 여부 판단
            if(totalPlus>ans[0] || (totalPlus==ans[0] && totalEmo>=ans[1])){
                ans[0] = totalPlus;
                ans[1] = totalEmo;
            }
        } else{
            //각 이모티콘에 대해 할인율 설정
            for(int r=0; r<4; r++){
                discounts[idx] = rates[r];
                setDiscount(idx+1);
            }
        }
    }
}