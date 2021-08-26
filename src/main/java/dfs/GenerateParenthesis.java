package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 22
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        GenerateParenthesis obj = new GenerateParenthesis();
        List<String> ans = obj.generateParenthesis(n);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sbu = new StringBuilder();
        dfs(n, 0, 0, sbu);
        return ans;
    }

    void dfs(int n, int left, int right, StringBuilder sbu) {
        //dfs结束条件
        if (left == n && right == n) {
            ans.add(sbu.toString());
            return;
        }
        if (left < n) {
            sbu.append("(");
            left++;
            dfs(n, left, right, sbu);
            sbu.deleteCharAt(sbu.length() - 1);
            left--;
        }
        if (right < left) {
            sbu.append(")");
            right++;
            dfs(n, left, right, sbu);
            sbu.deleteCharAt(sbu.length() - 1);
            right--;
        }
    }
}
