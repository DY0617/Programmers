class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        
        /*
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        */
        
        int idx=0;
        
        for(long i=left;i<=right;i++){
            answer[idx++]=Math.max((int)(i/(long)n)+1,(int)(i%(long)n)+1);
        }
        return answer;
    }
}