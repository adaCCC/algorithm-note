package dfs;

import common.TreeNode;
import util.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 144
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 二叉树的前序遍历
 * <p>
 * 解题思路：dfs；中序遍历（根、左、右）
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);

        List<Integer> ans = preorderTraversal(t1);
        System.out.println(GsonUtil.toJson(ans));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        dfs(node.left, ans);
        dfs(node.right, ans);
    }


}
