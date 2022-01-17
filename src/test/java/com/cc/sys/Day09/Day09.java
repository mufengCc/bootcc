package com.cc.sys.Day09;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 *
 * @Author: cc
 * @Date: 2021/12/23 2:48 下午
 */
public class Day09 {

    public static void main(String[] args) {

        Day09 day09 = new Day09();
        day09.show(123);
    }


    public boolean show(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x %= 10;
        }

        return true;
    }
}
