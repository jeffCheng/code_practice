class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int r=1;r<A.length;r++){
            for(int c=0;c<A[0].length;c++){
                int best = A[r-1][c];
                if(c > 0) best = Math.min(best, A[r-1][c-1]);
                if(c <A[0].length-1) best = Math.min(best, A[r-1][c+1]);
                A[r][c] +=best;
            }   
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[A.length-1])
            ans = Math.min(ans, x);
        return ans;
    }
}

class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                A[i][j] +=Math.min(A[i-1][j], Math.min(A[i-1][Math.max(0,j-1)], A[i-1][Math.min(A.length-1,j+1)]));
            }
        }
        return Arrays.stream(A[A.length-1]).min().getAsInt();
    }
}