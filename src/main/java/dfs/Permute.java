package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 46
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 * 给定一个不含重复数字的数组nums ，返回其所有可能的全排列。你可以按任意顺序返回答案。
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute obj = new Permute();
        List<List<Integer>> ans = obj.permute(nums);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(nums, 0, temp);
        return ans;
    }

    private void dfs(int[] nums, int start, LinkedList<Integer> temp) {
        //dfs结束条件
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            temp.add(nums[start]);
            dfs(nums, start + 1, temp);
            temp.pollLast();
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
