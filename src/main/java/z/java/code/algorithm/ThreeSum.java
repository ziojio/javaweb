package z.java.code.algorithm;

import z.java.code.LogUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        LogUtils.d("threeSum", "" + threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return list;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int a = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (a + b + c > 0) {
                    right--;
                } else if (a + b + c < 0) {
                    left++;
                } else if (a + b + c == 0) {
                    list.add(Arrays.asList(a, b, c));
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return list;
    }

}
