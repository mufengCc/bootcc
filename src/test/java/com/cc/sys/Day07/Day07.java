package com.cc.sys.Day07;

import java.util.Arrays;

/**
 * 数组串联
 * 地址：https://leetcode-cn.com/problems/concatenation-of-array/
 *
 * @Author: cc
 * @Date: 2021/11/11 10:54 上午
 */
public class Day07 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[] concatenation = getConcatenation(nums);
        System.out.println(concatenation);
    }

    public static int[] getConcatenation(int[] nums) {
        int[] array = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            array[i + nums.length] = nums[i];
        }
        return array;
    }


}
