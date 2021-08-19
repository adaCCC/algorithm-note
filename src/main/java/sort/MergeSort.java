package sort;

import util.GsonUtil;

/**
 * @author weilu
 * @date 2021/8/19
 * 归并排序（升序）
 * 时间复杂度：nlog2^n 稳定
 * <p>
 * 解题方法：递归，分而治之的思路
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 5};
        int left = 0, right = nums.length - 1;
        sort(nums, left, right);
        System.out.println(GsonUtil.toJson(nums));
    }

    public static void sort(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            //排序合并
            merge(nums, left, mid, right);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid || j <= right) {
            if (i <= mid && j <= right) {
                if (nums[i] < nums[j]) {
                    temp[index] = nums[i];
                    i++;
                } else {
                    temp[index] = nums[j];
                    j++;
                }
            } else if (i <= mid) {
                temp[index] = nums[i];
                i++;
            } else if (j <= right) {
                temp[index] = nums[j];
                j++;
            }
            index++;
        }
        for (int x = 0; x < index; x++) {
            nums[x + left] = temp[x];
        }
    }
}
