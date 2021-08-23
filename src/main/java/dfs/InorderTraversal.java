package dfs;

import common.TreeNode;
import util.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 94
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历
 * <p>
 * 解题思路：dfs；中序遍历（左、根、右）
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);

        List<Integer> ans = inorderTraversal(t1);
        System.out.println(GsonUtil.toJson(ans));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void dfs(TreeNode node, List<Integer> ans) {
        //dfs首先需要想清楚在什么情况结束
        if (node == null) {
            return;
        }
        dfs(node.left, ans);
        ans.add(node.val);
        dfs(node.right, ans);
    }
}
