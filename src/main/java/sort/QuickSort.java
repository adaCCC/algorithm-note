package sort;

import util.GsonUtil;

/**
 * @author weilu
 * @date 2021/8/19
 * 快排
 * 时间复杂度：nlog2^n ~ n^2
 * <p>
 * 解题思路：递归，分而治之的思路
 * 类比一堆人排成一排，现需要对他们按高矮顺序进行排队。
 * step1.从人群中找出最左边的人以他的身高作为对比身高，比他高的站他右边，比他矮的站左边;
 * step2.再依次对站在他左边和右边的人进行step1的操作。
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 5};
        int start = 0, end = nums.length - 1;
        quickSort(nums, start, end);
        System.out.println(GsonUtil.toJson(nums));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int left = start, right = end;
            int standard = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= standard) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= standard) {
                    left++;
                }
                nums[right] = nums[right];
            }
            nums[left] = standard;
            quickSort(nums, start, left);
            quickSort(nums, left + 1, end);
        }
    }
}
