package dfs;

import util.GsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author weilu
 * @date 2021/8/23
 * leetcode 17
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2 abc
 * 3 def
 * 4 ghi
 * 5 jkl
 * 6 mno
 * 7 pqrs
 * 8 tuv
 * 9 wxyz
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations obj = new LetterCombinations();
        List<String> ans = obj.letterCombinations(digits);
        System.out.println(GsonUtil.toJson(ans));
    }

    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    public List<String> letterCombinations(String digits) {
        StringBuilder sbu = new StringBuilder();
        dfs(digits, 0, sbu);
        return ans;
    }

    public void dfs(String digits, int start, StringBuilder sbu) {
        //当前dfs结束条件
        if (sbu.length() == digits.length()) {
            ans.add(sbu.toString());
            return;
        }
        char digit = digits.charAt(start);
        String letters = map.get(digit);
        for (int j = 0; j < letters.length(); j++) {
            sbu.append(letters.charAt(j));
            dfs(digits, start + 1, sbu);
            sbu.deleteCharAt(start);
        }
    }
}
