package dfs;

import common.TreeNode;
import util.GsonUtil;

/**
 * @author weilu
 * @date 2021/8/26
 * leetcode 110
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, null);
        TreeNode t4 = new TreeNode(15, null, null);
        TreeNode t3 = new TreeNode(20, t4, t5);
        TreeNode t2 = new TreeNode(9, null, null);
        TreeNode t1 = new TreeNode(3, t2, t3);
        System.out.println(GsonUtil.toJson(t1));
        boolean result = isBalanced(t1);
        System.out.println(result);
    }

    public static boolean isBalanced(TreeNode root) {
        if (dfs(root) != -1) {
            return true;
        }
        return false;
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
