package com.cc.sys.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: cc
 * @Date: 2022/1/13 6:13 下午
 */
public class Local {

    public static void main(String[] args) {

        show4();
    }


    /**
     * LocalDate  转 LocalDateTime
     *
     * @Author: Cc
     * @Date: 2022/1/13 6:24 下午
     **/
    public static void show() {
        LocalDate nowLocalDate = LocalDate.now();
        LocalDateTime localDateTime = nowLocalDate.atStartOfDay();
    }

    /**
     * Date  转 LocalDate
     *
     * @Author: Cc
     * @Date: 2022/1/13 6:24 下午
     **/
    public static void show2() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }


    /**
     * Date转LocalDate 并判断日期
     *
     * @Author: Cc
     * @Date: 2022/1/13 6:24 下午
     **/
    public static void show3() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }

    /**
     * LocalDateTime 转string
     *
     * @Author: Cc
     * @Date: 2022/1/13 6:30 下午
     **/
    public static void show4() {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 20, 59));

        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
    }



    /**
     * 判断createAt是否小于指定时间
     * 1: 是新人
     * 0：不是新人
     *
     * @Param: createAt 创建时间
     * @Param: redisKey
     * @Author: Cc
     * @Date: 2021/11/12 4:51 下午
     **/
    private boolean checkDate(Date createAt, String redisKey) {
        // 新人专区开始时间
        LocalDate beginLocalDate = LocalDate.of(2021, 12, 24);
        // 用户创建时间
        LocalDate createAtLocalDate = createAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // 用户创建时间增加7天
        LocalDate sevenLocalDate = createAtLocalDate.plusDays(7);
        LocalDate nowLocalDate = LocalDate.now();
        if (sevenLocalDate.isAfter(nowLocalDate) && !beginLocalDate.isAfter(createAtLocalDate)) {
            return true;
        } else {
            return false;
        }
    }

}
