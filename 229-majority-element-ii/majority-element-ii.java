import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
