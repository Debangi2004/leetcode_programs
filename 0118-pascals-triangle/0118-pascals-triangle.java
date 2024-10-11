import java.util.*;

class Solution {
    
    public static List<Integer> generateRows(int n){
        List<Integer> ansRow = new ArrayList<>();
        long res = 1;
        ansRow.add(1);
        for(int i=1;i<n;i++)
        {
            res=res*(n-i);
            res=res/i;
            ansRow.add((int)res);
        }
        return ansRow;
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans =  new ArrayList<>();
        for(int i = 1; i<=numRows ; i++)
        {
            ans.add(generateRows(i));
        }
        return ans;
    }
    public static void main(String args[])
    {
        int numRows=6;
        List<List<Integer>> ans =  generate(numRows);
        for(List<Integer> row : ans)
        {
            for(int ele : row){
                System.out.println(ele + " ");
            }
            System.out.println();
        }
    }
}