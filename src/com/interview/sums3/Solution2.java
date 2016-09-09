package com.interview.sums3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution2 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int compl = 0 - nums[i];
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			map.clear();
			for (int j = i + 1; j < nums.length; j++) {
				int innerCompl = compl - nums[j];
				boolean contain = map.containsKey(innerCompl);
				if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
					if (!contain)
						map.put(nums[j], j);
					continue;
				} else {
					if (contain) {
						res.add(Arrays.asList(nums[i], innerCompl, nums[j]));
					}
				}
				if (!contain)
					map.put(nums[j], j);
			}
		}
		return res;
	}
}