class Solution {
    /*
    DFS
    Time 20:30 21:08 finished
    Total Time: 38 miniutes
    */
    int res = 0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(helper(grid, i, j)) res++;
            }
        }   
        return res;
    }
    private boolean helper(char[][] grid, int i, int j){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]=='0') return false; 
        grid[i][j] = '0';
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid,i, j+1);
        helper(grid,i,j-1);
        return true;
    }
}