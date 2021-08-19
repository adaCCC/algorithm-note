package sort;

/**
 * @author weilu
 * @date 2021/8/19
 * 根据快排的思路找出数组中第k大的元素
 * <p>
 * 解题思路：充分理解快排
 */
public class SearchByQuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 4, 5};
        int start = 0, end = nums.length - 1;
        int k = 3;
        int ans = searchByquickSort(nums, start, end, k);
        System.out.println(ans);
    }

    public static int searchByquickSort(int[] nums, int start, int end, int k) {
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
            //需要理解standard位置已经找到并且不会再变，它的下标为left的值，且standard的左边的数一定比它小，右边的数一定都比它大
            nums[left] = standard;
            if (left == k - 1) {
                //standard为第k大的元素
                return standard;
            } else if (left > k - 1) {
                //在standard的左边找
                return searchByquickSort(nums, start, left, k);
            } else {
                //在standard的右边找
                return searchByquickSort(nums, left + 1, end, k);
            }
        }
        //默认没找到的情况返回Integer最小值
        return Integer.MIN_VALUE;
    }
}
