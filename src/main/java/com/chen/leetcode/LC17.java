package com.chen.leetcode;

import java.util.*;

/**
 * Created by zhoucy on 2024/7/20
 **/


public class LC17 {

    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    int depth = 0;
    Map<Character, String> phoneMap = new HashMap<Character, String>() {
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

        if (digits.length() == 0)
            return new ArrayList<>();
        depth = digits.length();
        char[] dig = digits.toCharArray();
        dfs(dig, 0);
        return res;
    }

    public void dfs(char[] dig, int begin) {
        if (begin == depth) {
            res.add(String.join("", path));
            return;
        }
        char num = dig[begin];
        for (int i = 0; i < phoneMap.get(num).length(); i++) {
            path.add(phoneMap.get(num).charAt(i) + "");
            dfs(dig, begin + 1);
            path.removeLast();
        }
    }

    /*********     另外一种解法，细节有点区别，特别是处理单个路径上的字符，使用SB  *********/
//
//    List<String> combinations = new ArrayList<String>();
//    Map<Character, String> phoneMap = new HashMap<Character, String>() {
//        {
//            put('2', "abc");
//            put('3', "def");
//            put('4', "ghi");
//            put('5', "jkl");
//            put('6', "mno");
//            put('7', "pqrs");
//            put('8', "tuv");
//            put('9', "wxyz");
//        }
//    };
//
//    public List<String> letterCombinations(String digits) {
//
//        if (digits.length() == 0) {
//            return combinations;
//        }
//
//        backtrack(digits, 0, new StringBuffer());
//        return combinations;
//    }
//
//    public void backtrack(String digits, int index,
//                          StringBuffer combination) {
//        if (index == digits.length()) {
//            combinations.add(combination.toString());
//        } else {
//            char digit = digits.charAt(index);
//            String letters = phoneMap.get(digit);
//            int lettersCount = letters.length();
//            for (int i = 0; i < lettersCount; i++) {
//                combination.append(letters.charAt(i));
//                backtrack(digits, index + 1, combination);
//                combination.deleteCharAt(index);
//            }
//        }
//    }
}
