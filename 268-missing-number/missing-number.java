class Solution {
    public int missingNumber(int[] a) {
        int N=a.length;
        int maxi=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            maxi=Math.max(a[i],maxi);
        }
        for (int i = 0; i < N; i++) {

            // flag variable to check
            //if an element exists
            int flag = 0;

            //Search the element using linear search:
            for (int j = 0; j < N ; j++) {
                if (a[j] == i) {

                    // i is present in the array:
                    flag = 1;
                    break;
                }
            }

            // check if the element is missing
            //i.e flag == 0:

            if (flag == 0) return i;
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return maxi+1;
    }
}