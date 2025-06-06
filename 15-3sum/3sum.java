import java.util.AbstractList;

class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
		return new AbstractList<List<Integer>>() {

			List<List<Integer>> ans;

			@Override
			public int size() {
				if (ans == null)
					ans = createList(arr);
				return ans.size();
			}

			@Override
			public List<Integer> get(int index) {
				if (ans == null)
					ans = createList(arr);
				return ans.get(index);
			}
		};
	}

	private List<List<Integer>> createList(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		int len = arr.length;

		Arrays.sort(arr);
		for (int i = 0; i < len - 2 && arr[i] <= 0; ++i) {
			if (i != 0 && arr[i - 1] == arr[i])
				continue;
			twoSum(ans, arr, i + 1, len - 1, -arr[i]);
		}
		return ans;
	}

	private void twoSum(List<List<Integer>> ans, int[] arr, int left, int right, int target) {
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum < target) {
				++left;
				continue;
			}
			if (sum > target) {
				--right;
				continue;
			}

			ans.add(Arrays.asList(-target, arr[left++], arr[right--]));

			while (left <= right && arr[left - 1] == arr[left]) {
				++left;
			}
		}
	}

}