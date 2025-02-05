/*
 * Copyright (C) 2025 Baidu, Inc. All Rights Reserved.
 */
package org.learn.cs.problems.array;

public class Solution {
    /**
     * 求最长回文子串<br>
     * https://leetcode.cn/problems/longest-palindromic-substring/ <br>
     * https://labuladong.online/algo/essential-technique/array-two-pointers-summary/#%E5%9B%9E%E6%96%87%E4%B8%B2%E5
     * %88%A4%E6%96%AD <br>
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            if (res1.length() > res2.length() && res1.length() > res.length()) {
                res = res1;
            } else if (res2.length() > res1.length() && res2.length() > res.length()) {
                res = res2;
            }
        }
        return res;
    }

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l -= 1;
                r += 1;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }

    int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            System.out.println(i);
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
//        int[] weights = new int[] {3, 2, 2, 4, 1, 4};
        int[] weights = new int[] {1,2,3,1,1};
        System.out.println(new Solution().f(weights, 3));
    }
}
