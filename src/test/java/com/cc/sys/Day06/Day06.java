package com.cc.sys.Day06;

import java.util.Arrays;

/**
 * 地址：https://leetcode-cn.com/problems/teemo-attacking/
 * 提莫攻击
 *
 * @Author: cc
 * @Date: 2021/11/10 4:44 下午
 */
public class Day06 {

    public static void main(String[] args) {
        int[] timeSeries = {1, 2, 4};
        int duration = 2;
      // System.out.println(findPoisonedDuration(timeSeries, duration));
        System.out.println(findPoisonedDuration2(timeSeries, duration));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        // 中毒次数
        int val = 0;
        // 中毒持续时间
        int expired = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] >= expired) {
                val += expired;
            } else {
                val += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }
        return val;
    }


    /**
     * 这个更好理解
     *
     * @Author: Cc
     * @Date: 2021/11/11 10:54 上午
     **/
    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        if(timeSeries.length == 1){
            return duration;
        }
        int cnt = 0;
        for(int i = 0; i < timeSeries.length - 1; i++){
            cnt += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return cnt + duration;
    }

}
