class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));

        int newInterval[]=intervals[0];
        result.add(newInterval);

        for(int[]interval : intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
            else{
                newInterval=interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}