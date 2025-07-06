class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        // Map: subset size -> list of subset sums
        Map<Integer, List<Integer>> leftMap = getSubsetSums(left);
        Map<Integer, List<Integer>> rightMap = getSubsetSums(right);

        int minDiff = Integer.MAX_VALUE;

        for (int size = 0; size <= n; size++) {
            List<Integer> leftSums = leftMap.get(size);
            List<Integer> rightSums = rightMap.get(n - size);
            Collections.sort(rightSums); // Needed for binary search

            for (int leftSum : leftSums) {
                int target = totalSum / 2 - leftSum;

                // Binary search for closest sum in rightSums
                int idx = Collections.binarySearch(rightSums, target);
                if (idx >= 0) {
                    int s1 = leftSum + rightSums.get(idx);
                    int s2 = totalSum - s1;
                    minDiff = Math.min(minDiff, Math.abs(s1 - s2));
                } else {
                    idx = -idx - 1;

                    // Check both idx and idx - 1 for best approximation
                    if (idx < rightSums.size()) {
                        int s1 = leftSum + rightSums.get(idx);
                        int s2 = totalSum - s1;
                        minDiff = Math.min(minDiff, Math.abs(s1 - s2));
                    }
                    if (idx > 0) {
                        int s1 = leftSum + rightSums.get(idx - 1);
                        int s2 = totalSum - s1;
                        minDiff = Math.min(minDiff, Math.abs(s1 - s2));
                    }
                }
            }
        }

        return minDiff;
    }

    private Map<Integer, List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0, count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    count++;
                }
            }
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
        }

        return map;
    }
}