import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        boolean[][] visitedTable = new boolean[table.length][table.length];
        boolean[][] visitedBoard = new boolean[game_board.length][game_board.length];
        List<List<int[]>> boardList = new ArrayList<>();
        List<List<int[]>> tableList = new ArrayList<>();

        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){

                if (table[i][j] == 1 && !visitedTable[i][j]){
                    bfs(i, j, visitedTable, table, 1, tableList);
                }

                if (game_board[i][j] == 0 && !visitedBoard[i][j]){
                    bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
        }

        answer = findBlock(boardList, tableList);

        return answer;
    }

    public int findBlock(List<List<int[]>> board, List<List<int[]>> table){
        int size = 0;
        int tableLen = table.size();
        int boardLen = board.size();
        boolean[] visitedBoard = new boolean[boardLen];
        for (int i = 0; i < tableLen; i++){
            List<int[]> tablePoints = table.get(i);
            for (int j = 0; j < boardLen; j++){
                List<int[]> boardPoints = board.get(j);

                if (tablePoints.size() == boardPoints.size() && !visitedBoard[j]){ //좌표 개수 같을때
                    if(isRotate(boardPoints, tablePoints)){ //회전해서 맞는지 확인
                        size += tablePoints.size();
                        visitedBoard[j] = true;
                        break;
                    }
                }
            }

        }

        return size;
    }

    public boolean isRotate(List<int[]> board, List<int[]> table){
        boolean isCollect = false;

        board.sort((o1, o2) -> {
            return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < 4; i++){ //table퍼즐 0, 90, 180, 270도 회전

            table.sort((o1, o2) -> {
                return o1[0] > o2[0]?1 : o1[0] < o2[0]?-1 : Integer.compare(o1[1], o2[1]);
            });
            int nearZeroX = table.get(0)[0];
            int nearZeroY = table.get(0)[1];

            for (int j = 0; j < table.size(); j++){
                table.get(j)[0] -= nearZeroX;
                table.get(j)[1] -= nearZeroY;
            }


            boolean isCollectPoint = true;
            for (int j = 0; j < board.size(); j++){ //좌표 비교
                int[] boardPoint = board.get(j);
                int[] tablePoint = table.get(j);

                if (boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]){
                    isCollectPoint = false;
                    break;
                }
            }

            if (isCollectPoint){
                isCollect = true;
                break;
            } else{ //90도 회전 : x,y -> y, -x
                for(int j = 0; j < table.size(); j++){
                    int temp = table.get(j)[0];
                    table.get(j)[0] = table.get(j)[1];
                    table.get(j)[1] = -temp;
                }
            }
        }
        return isCollect;

    }



    public void bfs(int currentX, int currentY, boolean[][] visited, int[][] graph,
                      int blockOrEmpty, List<List<int[]>> list){

        Queue<int[]> queue = new LinkedList<>();
        visited[currentX][currentY] = true;
        queue.add(new int[]{currentX, currentY});
        List<int[]> subList = new ArrayList<>();
        subList.add(new int[]{currentX-currentX, currentY-currentY});

        while (!queue.isEmpty()){
            int[] pop = queue.remove();
            int popX = pop[0];
            int popY = pop[1];

            for (int i = 0; i < 4; i++){
                int nextX = popX + dx[i];
                int nextY = popY + dy[i];
                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph.length){
                    continue;
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] == blockOrEmpty){

                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    subList.add(new int[]{nextX-currentX, nextY-currentY});
                }
            }
        }
        list.add(subList);
    }
}