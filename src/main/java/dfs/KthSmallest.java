package dfs;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 230
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 解题思路：中序遍历
 */
public class KthSmallest {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(25, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);
        int k = 3;
        int ans = kthSmallest(t1, 3);
        System.out.println(ans);
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, k, list);
        return list.get(k - 1);
    }

    static void dfs(TreeNode node, int k, List<Integer> list) {
        //dfs结束条件
        if (list.size() >= k || node == null) {
            return;
        }
        dfs(node.left, k, list);
        list.add(node.val);
        dfs(node.right, k, list);
    }
}
