class Solution {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0; // \U0001f534 Fix: Handle empty array early

        Arrays.sort(arr);
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                continue; // skip duplicates
            } else if (arr[i] == arr[i - 1] + 1) {
                currLen++;
            } else {
                currLen = 1; // reset for new sequence
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
