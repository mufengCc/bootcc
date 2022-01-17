package com.cc.sys.Day05;

import java.util.Arrays;

/**
 * 地址:https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 * 给你一个数字数组 arr 。
 * <p>
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * <p>
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 *
 * @Author: cc
 * @Date: 2021/11/10 1:50 下午
 */
public class Day05 {

    public static void main(String[] args) {
        System.out.println(show());
    }

    public static boolean show() {
        Integer[] arr = {3, 5, 1};  //1  3   5
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
