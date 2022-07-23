package com.ziojio.code.algorithm.find;

import com.ziojio.code.LogUtils;

import java.util.Arrays;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "abaccdeff";
        int[] arr = new int[26];
        LogUtils.d("FirstUniqChar", "" + Arrays.toString(arr));
        LogUtils.d("FirstUniqChar", "" + firstUniqChar(s));
    }

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        int[] arr = new int[26];
        for (char aChar : chars) {
            arr[aChar - 'a']++;
        }
        for (char aChar : chars) {
            if (arr[aChar - 'a'] == 1) {
                return aChar;
            }
        }
        return ' ';
    }

}