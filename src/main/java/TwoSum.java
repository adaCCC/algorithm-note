import util.GsonUtil;

import java.util.*;

/**
 * @author weilu
 * @date 2021/8/19
 * 类似 https://leetcode-cn.com/problems/two-sum/
 * 给定一个整数数组 nums 和一个整数目标值target，请你在该数组中找出和为目标值target的两个整数下标的组合，并返回所有的组合，
 * 数组中的元素不可以重复使用,且数组中元素不相同
 * <p>
 * 解题方法：hashmap的应用
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5};
        int target = 5;
        List<List<Integer>> ans = twoSum(nums, target);
        System.out.println(GsonUtil.toJson(ans));
    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int needVal = target - nums[i];
            if (map.keySet().contains(needVal)) {
                ans.add(Arrays.asList(map.get(needVal), i));
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
