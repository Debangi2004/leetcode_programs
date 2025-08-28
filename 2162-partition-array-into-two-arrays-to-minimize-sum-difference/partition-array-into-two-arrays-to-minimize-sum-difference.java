class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();

        // Split into two halves
        int[] left = Arrays.copyOfRange(nums, 0, n / 2);
        int[] right = Arrays.copyOfRange(nums, n / 2, n);

        // Generate subset sums by size
        Map<Integer, List<Integer>> leftSums = generateSums(left);
        Map<Integer, List<Integer>> rightSums = generateSums(right);

        int target = total / 2;
        int ans = Integer.MAX_VALUE;

        // For each possible size from left half
        for (int leftSize : leftSums.keySet()) {
            int rightSize = n / 2 - leftSize;
            if (!rightSums.containsKey(rightSize)) continue;

            List<Integer> lList = leftSums.get(leftSize);
            List<Integer> rList = rightSums.get(rightSize);

            Collections.sort(rList);

            for (int sumLeft : lList) {
                int need = target - sumLeft;

                // binary search on right sums
                int idx = Collections.binarySearch(rList, need);
                if (idx < 0) idx = -idx - 1;

                if (idx < rList.size()) {
                    int sumRight = rList.get(idx);
                    int sumChosen = sumLeft + sumRight;
                    ans = Math.min(ans, Math.abs(total - 2 * sumChosen));
                }

                if (idx > 0) {
                    int sumRight = rList.get(idx - 1);
                    int sumChosen = sumLeft + sumRight;
                    ans = Math.min(ans, Math.abs(total - 2 * sumChosen));
                }
            }
        }
        return ans;
    }

    private Map<Integer, List<Integer>> generateSums(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = arr.length;
        int subsets = 1 << n;

        for (int mask = 0; mask < subsets; mask++) {
            int sum = 0, bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    bits++;
                }
            }
            map.computeIfAbsent(bits, k -> new ArrayList<>()).add(sum);
        }
        return map;
    }
}
