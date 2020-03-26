class Solution {
    /*
    [[1,3],[2,6],[8,10],[15,18]]
    
    */
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        //reuse the original array 
        //like fast and slow index
        int index = 0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[index][1] >= intervals[i][0]){
                intervals[index][1] = Math.max(intervals[index][1],  intervals[i][1]);
            }else{
                index++;
                intervals[index][0] = intervals[i][0];
                intervals[index][1] = intervals[i][1];
            }
        }
        int[][] res = new int[index+1][2];
        
        for(int i=0;i<=index;i++){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        
        return res;
    }
}