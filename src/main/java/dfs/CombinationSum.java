package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 39
 * https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 * <p>
 * 解题思路：归根结底还是一个组合问题，只需要额外判断哪些组合满足题目中的要求即可
 */
public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = obj.combinationSum(candidates, target);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(candidates, target, 0, temp, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, int start, LinkedList<Integer> temp, int sum) {
        //dfs结束条件
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //dfs结束条件
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i, temp, sum);
            temp.pollLast();
            sum -= candidates[i];
        }
    }
}
