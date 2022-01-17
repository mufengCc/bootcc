package com.cc.sys;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @Author: cc
 * @Date: 2021/12/28 1:27 下午
 */
public class Day11 {


    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate.now(ZoneId.systemDefault());

        LocalDate now = LocalDate.parse("2022-01-02", dateTimeFormatter);
        LocalDateTime localDateTime = now.atStartOfDay();
        System.out.println(dateTimeFormatter.format(localDateTime));

        ZoneId.systemDefault();
        Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

    }
}
