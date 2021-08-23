package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 131
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 分割回文串
 * 给你一个字符串s，请你将s分割成一些子串，使每个子串都是回文串 。返回s所有可能的分割方案。
 * 回文串是正着读和反着读都一样的字符串。
 */
public class Partition {
    public static void main(String[] args) {
        String s = "aab";
        Partition obj = new Partition();
        List<List<String>> ans = obj.partition(s);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        LinkedList<String> temp = new LinkedList<>();
        dfs(s, 0, temp);
        return ans;
    }

    void dfs(String s, int start, LinkedList<String> temp) {
        //dfs结束条件
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String segStr = s.substring(start, i + 1);
            if (isPalindrome(segStr)) {
                temp.add(segStr);
                dfs(s, i + 1, temp);
                temp.pollLast();
            }
        }
    }

    /**
     * 判断是否是回文
     *
     * @param s
     * @return
     */
    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
