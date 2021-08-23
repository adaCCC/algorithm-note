package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 77
 * https://leetcode-cn.com/problems/combinations/
 * 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按任何顺序返回答案。
 */
public class Combine {
    public static void main(String[] args) {
        Combine obj = new Combine();
        int n = 3, k = 2;
        List<List<Integer>> ans = obj.combine(n, k);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(n, k, 1, temp);
        return ans;
    }

    private void dfs(int n, int k, int start, LinkedList<Integer> temp) {
        //dfs结束条件
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, temp);
            temp.pollLast();
        }
    }
}
