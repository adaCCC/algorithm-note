import util.GsonUtil;

import java.util.*;

/**
 * @author weilu
 * @date 2021/8/20
 * 给定一个整数数组 nums 和一个整数目标值target，请你在该数组中找出和为目标值target的两个整数下标的组合，并返回所有的组合，
 * 数组中的元素不可以重复使用,数组中存在值相同的元素
 * <p>
 * 解题方法：
 * 1.直接用hashmap
 * 2.转换为典型的组合问题用dfs，该方法时间复杂度比hashmap高，但dfs是必须掌握的一种常用解题方法
 */
public class TwoSumWithSameData {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 3, 2, 1};
        int target = 5;
        List<List<Integer>> ans1 = twoSum(nums, target);
        System.out.println(GsonUtil.toJson(ans1));

        List<List<Integer>> ans2 = twoSumByDfs(nums, target);
        System.out.println(GsonUtil.toJson(ans2));
    }

    /**
     * hashmap的方式
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int needVal = target - nums[i];
            Set<Integer> set = map.get(needVal);
            if (set != null) {
                for (int index : set) {
                    ans.add(Arrays.asList(index, i));
                }
            }
            Set<Integer> curNumSet = map.getOrDefault(nums[i], new HashSet<>());
            curNumSet.add(i);
            map.put(nums[i], curNumSet);
        }
        return ans;
    }

    /**
     * dfs组合方式
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSumByDfs(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), 0, target, ans);
        return ans;
    }

    public static void dfs(int[] nums, int start, LinkedList<Integer> temp, int sum, int target, List<List<Integer>> ans) {
        if (sum == target && temp.size() == 2) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() >= 2) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(i);
            sum += nums[i];
            dfs(nums, i + 1, temp, sum, target, ans);
            temp.pollLast();
            sum -= nums[i];
        }
    }
}
