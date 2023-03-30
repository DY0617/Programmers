import java.util.*;

class Solution {
    int n,m;
    int answer;
    int[] member=new int[1322];
    
    public class Point {
        int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int n, int m, int[][] timetable) {
        answer = 0;
        this.n=n;
        this.m=m;
        
        for(int[] now:timetable){
            member[now[0]]++;
            member[now[1]+1]--;
        }
        
        int maxNum=0;
        
        for(int i=600;i<=1320;i++){
            member[i]+=member[i-1];
            
            maxNum=Math.max(member[i],maxNum);
        }
        
        if(maxNum<=1)
            return 0;
        
        //2. 가능한 거리 순회하며 max만큼 배치할 수 있으면 리턴
        ArrayList<Point> list = new ArrayList<>();
        for (int dist = 2 * (n - 1); dist >= 1; dist--) {
        
        	//첫번쨰 row의 시작지점을 변경 
            for (int sy = 0; sy < n; sy++) {
                list.clear();
                int cnt = 0;
                //맵 전체 순회
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        
                        if (i == 0 && j < sy) continue;
                        
                        //해당 위치에 회원 들어갈 수 있는지 확인
                        boolean flag = true;
                        for (Point p : list) {
                            if (Math.abs(p.x - i) + Math.abs(p.y - j) >= dist)
                                continue;
                            flag = false;
                            break;
                        }
                        if (flag) {
                            if (++cnt == maxNum)
                                return dist;
                            list.add(new Point(i, j));
                        }
                    }
                }
            }
        }
        return answer;
    }
}