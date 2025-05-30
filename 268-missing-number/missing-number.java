class Solution {
    public int missingNumber(int[] a) {
        int N = a.length;
        int xor1 = 0, xor2 = 0;

        // XOR of array elements
        for (int i = 0; i < N; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1); // XOR up to N (i+1 goes from 1 to N)
        }

        // XOR of xor1 and xor2 gives the missing number
        return xor1 ^ xor2;
    }
}
