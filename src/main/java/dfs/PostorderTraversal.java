package dfs;

import common.TreeNode;
import util.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 145
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 二叉树的后序遍历
 * 解题思路：dfs；中序遍历（左、右、根）
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);

        List<Integer> ans = postorderTraversal(t1);
        System.out.println(GsonUtil.toJson(ans));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public static void dfs(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        dfs(node.left, ans);
        dfs(node.right, ans);
        ans.add(node.val);
    }

}
