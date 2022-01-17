package com.cc.sys;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.cc.sys.system.entity.SysUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: cc
 * @Date: 2021/9/30 2:23 下午
 */
public class Test {


    public static void main(String[] args) {


        // show4();
        int[] str = {2, 5, 4, 1, 9, 11};
        int res = 9;
        //twoSum(str, res);
//
//        Test t = new Test();
//        t.twoSum4(str, 0, res, new ArrayList<>());
//        System.out.println(t.result);


        twoSum3(str, res);


    }


    public void show() {
        DateTime dateTime = DateUtil.beginOfDay(DateUtil.date());
        DateTime dateTime1 = DateUtil.endOfDay(DateUtil.date());
        int compare = DateUtil.compare(dateTime, dateTime1);
        System.out.println(compare);

        List<SysUser> cList = new ArrayList<>();
        List<SysUser> dList = new ArrayList<>();
        SysUser dto_1 = new SysUser();
        dto_1.setId(2000);

        SysUser dto_2 = new SysUser();
        dto_1.setId(3000);

        cList.add(dto_1);
        dList.add(dto_2);

        cList.addAll(dList);

        cList.forEach(e -> {
            e.setName("哈哈");
        });

        System.out.println(cList.get(0).getName());
        System.out.println(dList.get(0).getName());
    }

    public static void show2() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

        LocalDate now1 = LocalDate.now();

        String format1 = now1.format(dateTimeFormatter);
        System.out.println(format1);

    }


    public static void show3() {

        Integer[] str = {51, 8, 5, 4, 7, 2};

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 0; j < str.length - 1 - i; j++) {
                if (str[j] > str[j + 1]) {
                    int tmp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = tmp;
                }
                System.out.println(str[i] + ":" + str[j]);
            }
            //System.out.println(Arrays.toString(str));
        }
        System.out.println(Arrays.toString(str));
    }

    public static void show4() {
        Integer[] str = {3, 2, 4};
        int res = 6;

        boolean flag = false;
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 1; j < str.length; j++) {
                if (str[i] + str[j] == res) {
                    System.out.println(i + ":" + j);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("下标为：" + i + "" + j);
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> cMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (cMap.containsKey(target - nums[i])) {
                System.out.println("下标为：" + cMap.get(target - nums[i]) + "" + i);
                return new int[]{cMap.get(target - nums[i]), i};
            }
            cMap.put(nums[i], i);
        }
        return new int[0];
    }


    List<List<Integer>> result = new ArrayList<>();

    public void twoSum4(int[] nums, int k, int target, List<Integer> a) {

        if (target == 0) {
            result.add(new ArrayList<>(a));
            return;
        }
        if (k > nums.length) {
            return;
        }

        for (int i = k; i < nums.length; ++i) {
            int s = target - nums[i];
            if (s >= 0) {
                a.add(nums[i]);
                twoSum4(nums, i + 1, s, a);
                a.remove(a.size() - 1);
            }
        }

    }

}
