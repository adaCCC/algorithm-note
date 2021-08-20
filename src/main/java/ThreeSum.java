import util.GsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weilu
 * @date 2021/8/19
 * 给定一个整数数组 nums 和一个整数目标值target，请你在该数组中找出和为目标值target的三个整数下标，返回一个满足条件的即可。
 * 数组中的元素不可以重复使用,且数组中元素不相同（TwoSum加强版）
 * <p>
 * 解题方法：利用hashmap数据结构减少一层循环遍历
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 5, -1, -2};
        int target = 5;
        int[] ans = threeSum(nums, target);
        System.out.println(GsonUtil.toJson(ans));
    }

    public static int[] threeSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, int[]> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int val1 = nums[i];
            for (int j = i + 1; j < len; j++) {
                int val2 = nums[j];
                int[] indexArray = map.get(val2);
                if (indexArray != null) {
                    indexArray[2] = j;
                    return indexArray;
                } else {
                    int needVal = target - val1 - val2;
                    map.put(needVal, new int[]{i, j, -1});
                }
            }
        }
        return null;
    }
}
