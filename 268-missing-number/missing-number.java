class Solution {
    public int missingNumber(int[] a) {
        int N=a.length;
        int hash[] = new int[N + 1]; //hash array

        // storing the frequencies:
        for (int i = 0; i < N; i++)
            hash[a[i]]++;

        //checking the freqencies for numbers 1 to N:
        for (int i = 0; i < N; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return N;
    }
}