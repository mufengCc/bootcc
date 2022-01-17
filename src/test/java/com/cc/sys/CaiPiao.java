package com.cc.sys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: cc
 * @Date: 2021/12/24 3:51 下午
 */
public class CaiPiao {

    public static void main(String[] args) {
        String nums = "001 004 006 008 011 015 019 024 026 028 " +
                "034 036 044 046 047 048 049 066 067 068 " +
                "069 089 112 113 114 115 116 117 118 119 " +
                "122 123 124 125 126 127 128 134 135 136 " +
                "144 145 146 147 148 156 158 166 167 168 " +
                "224 226 228 234 236 244 245 246 247 248 " +
                "249 256 258 266 267 268 269 289 344 345 " +
                "346 356 366 445 446 447 448 449 456 458 " +
                "466 467 468 469 489 566 568 667 668 669 " +
                "689";
        StringBuffer str = new StringBuffer();
        List<String> newNumList = getNewNum(nums);
        newNumList.forEach( e -> {
            str.append(e).append(" ");
        });
        System.out.println(str);
    }

    public static List<String> getNewNum(String nums) {
        List<String> newList = Arrays.asList(nums.split(" "));
        List<String> cList = new ArrayList<>();
        cList.addAll(newList);

        // 旧开奖号
        List<String> oldNumList = getOldNum();
        // 去重
        cList.removeAll(oldNumList);

        System.out.println("原数据为:" + newList.size() + "注，去重之后为:" + cList.size() + "注, 删除了:" + (newList.size() - cList.size()) + "注");
        return cList;
    }


    private static List<String> getOldNum() {
        List<String> cList = new ArrayList<>();
//        List<String> kjNum = getKjNum();
//        List<String> sjNum = getSjNum();
//        List<String> rjNum = getRjNum();
//        cList.addAll(kjNum);
//        cList.addAll(sjNum);
//        cList.addAll(rjNum);
        return cList;
    }

    /**
     * 开奖号 前20期
     *
     * @Author: Cc
     * @Date: 2021/12/24 4:31 下午
     **/
    public static List<String> getRjNum() {
        List<String> cList = new ArrayList<>();
        cList.add("349");
        cList.add("279");
        cList.add("001");
        cList.add("379");
        cList.add("024");
        cList.add("788");
        cList.add("129");
        cList.add("489");
        cList.add("016");
        cList.add("289");
        cList.add("379");
        return cList;
    }


    /**
     * 开机号 前10期
     *
     * @Author: Cc
     * @Date: 2021/12/24 4:31 下午
     **/
    public static List<String> getKjNum() {
        List<String> cList = new ArrayList<>();
        cList.add("389");
        cList.add("236");
        cList.add("046");
        cList.add("009");
        cList.add("247");
        cList.add("178");
        cList.add("479");
        cList.add("048");
        cList.add("147");
        return cList;
    }

    /**
     * 试机号 前10期
     *
     * @Author: Cc
     * @Date: 2021/12/24 4:31 下午
     **/
    public static List<String> getSjNum() {
        List<String> cList = new ArrayList<>();
        cList.add("147");
        cList.add("057");
        cList.add("367");
        cList.add("199");
        cList.add("188");
        cList.add("367");
        cList.add("149");
        cList.add("589");
        cList.add("568");
        return cList;
    }

}
