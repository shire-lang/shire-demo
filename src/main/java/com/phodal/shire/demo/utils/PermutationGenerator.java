package com.phodal.shire.demo.utils;

import java.util.ArrayList;
import java.util.List;

public class PermutationGenerator {
    public static List<List<Integer>> generatePermutations(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.size()];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    private static void backtrack(List<Integer> nums, List<Integer> tempList, List<List<Integer>> result, boolean[] used) {
        if (tempList.size() == nums.size()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i]) {
                continue; // Skip already used numbers
            }
            if (i > 0 && nums.get(i).equals(nums.get(i - 1)) && !used[i - 1]) {
                continue; // Skip duplicates to avoid redundant work
            }
            used[i] = true;
            tempList.add(nums.get(i));
            backtrack(nums, tempList, result, used);
            used[i] = false; // Backtrack
            tempList.remove(tempList.size() - 1);
        }
    }
}
