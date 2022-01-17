package com.cc.sys.Day08;

/**
 * 地址：https://leetcode-cn.com/problems/reverse-integer/
 * 题目：整数反转
 *
 * @Author: cc
 * @Date: 2021/11/11 11:38 上午
 */
public class Day08 {

    public static void main(String[] args) {
        int reverse = reverse(1230);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        String[] split = Integer.toString(x).split("");
        for (int i = split.length; i > 0; i--) {
            if (i == split.length && split[i - 1].equals("0") && split.length > 0) {
                continue;
            }
            sb.append(split[i - 1]);
        }
        return Integer.parseInt(sb.toString());
    }

}
