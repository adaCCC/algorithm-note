package sort;

import util.GsonUtil;

/**
 * @author weilu
 * @date 2021/8/19
 * 冒泡排序（升序排序）
 * 时间复杂度：最好的情况O(n) 最坏的情况O(n^2)
 * <p>
 * 解题方法：嵌套for循环，比较常规的方法
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 5};
        bubbleSort(nums);
        System.out.println(GsonUtil.toJson(nums));
    }

    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //设置flag标示，若在遍历中没有发生元素交换则认为已经排好序，break跳出循环
            boolean flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
