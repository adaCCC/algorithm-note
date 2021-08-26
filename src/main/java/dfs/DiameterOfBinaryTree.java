package dfs;

import common.TreeNode;
import util.GsonUtil;

/**
 * @author weilu
 * @date 2021/8/26
 * leetcode 543
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t3 = new TreeNode(3, t4, t5);
        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t1 = new TreeNode(1, t2, t3);
        System.out.println(GsonUtil.toJson(t1));
        int result = obj.diameterOfBinaryTree(t1);
        System.out.println(result);
    }

    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        ans = Math.max(ans, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
