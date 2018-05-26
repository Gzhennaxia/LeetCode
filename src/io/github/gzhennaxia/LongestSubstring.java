package io.github.gzhennaxia;

import java.util.Arrays;

/**
 * @Description:
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @Author: LiBo
 * @Date: 2018/5/26下午 07:31
 */
public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
    }

    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        //最长字串的最左边的位序。
        int left = -1;

        //不含有重复字符的最长子串的长度。
        int maxLength = 0;

        //ASCII表共能表示256个字符,charArray中的下标为字符对应的ASCII码，数组元素为该字符在字符串中当前字符之前的最右位序。
        int[] charArray = new int[256];
        Arrays.fill(charArray, -1);

        for (int i = 0; i < s.length(); i++){
            //比较当前字符 上一次 出现的位序与左标记的大小
            left = Math.max(left, charArray[s.charAt(i)]);

            //更新当前字符在数组中的位序值
            charArray[s.charAt(i)] = i;

            //更新满足条件的最长字串长度
            maxLength = Math.max(maxLength, i - left);
        }
        return maxLength;
    }
}
