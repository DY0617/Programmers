class Solution {
    
    boolean[][] pillar;
    boolean[][] bar;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n + 1][n + 1];
        bar = new boolean[n + 1][n + 1];
        
        int count = 0;
        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];
            
            if(type == 0) { //기둥을
                if(action == 1) { //설치한다
                    if(checkPillar(x, y)) {
                        pillar[x][y] = true;
                        count++;
                    }  
                } else { //삭제한다
                    pillar[x][y] = false;
                    if(canDelete(n) == false) pillar[x][y] = true;
                    else count--;
                }
            } else { //보를
                if(action == 1) {
                    if(checkBar(x, y)) { //설치한다
                        bar[x][y] = true;
                        count++;
                    } 
                } else { //삭제한다
                    bar[x][y] = false;
                    if(canDelete(n) == false) bar[x][y] = true;
                    else count--;
                }
            }
        }
        
        int[][] result = new int[count][3];
        int idx = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j; 
                    result[idx++][2] = 0;
                }
                if(bar[i][j]) {
                    result[idx][0] = i;
                    result[idx][1] = j;
                    result[idx++][2] = 1;
                }
            }
        }
        return result;
    }
    
    public boolean canDelete(int n) {    
        for(int i = 0; i <= n; i++) { 
            for(int j = 0; j <= n; j++) { 
                if(pillar[i][j] && checkPillar(i, j) == false)  return false; // 기둥이 해당 위치에 있을 수 없다면 false 
                else if(bar[i][j] && checkBar(i, j) == false) return false; // 바닥이 해당 위치에 있을 수 없다면 false 
            }
        }
        return true;
    }
    
    public boolean checkPillar(int x, int y) {
        if(y == 0) return true; //바닥에 설치하는 경우
        else if(y > 0 && pillar[x][y - 1]) return true; //아래 기둥이 있는 경우
        else if(x > 0 && bar[x - 1][y] || bar[x][y]) return true;
        return false;
    }
    
    public boolean checkBar(int x, int y) {
        if(y > 0 && pillar[x][y - 1] || pillar[x + 1][y - 1]) return true; // 한쪽 끝에 기둥이 있는 경우
        else if(x > 0 && bar[x - 1][y] && bar[x + 1][y]) return true; //양쪽 끝이 보와 동시에 연결되어 있는 경우
        return false;
    }
}
