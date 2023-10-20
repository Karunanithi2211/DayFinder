package com.nivak.dayfinder.findday;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FindDay {
    public String dayCheck(int dateofinp,String monthofinp,int yearofinp){
        int date = dateofinp;
        String month = monthofinp;
        int year = yearofinp;

        Map<String, Integer> months = new HashMap<>();
        months.put("jan", 0);
        months.put("feb", 3);
        months.put("mar", 3);
        months.put("apr", 6);
        months.put("may", 1);
        months.put("june", 4);
        months.put("july", 6);
        months.put("aug", 2);
        months.put("sep", 5);
        months.put("oct", 0);
        months.put("nov", 3);
        months.put("dec", 5);

        Map<String, String> days = new HashMap<>();
        days.put("-1", "Saturday");
        days.put("0", "Sunday");
        days.put("1", "Monday");
        days.put("2", "Tuesday");
        days.put("3", "Wednesday");
        days.put("4", "Thursday");
        days.put("5", "Friday");
        days.put("6", "Saturday");

        int step1 = Integer.parseInt(String.valueOf(year).substring(2));
        int step2 = step1 / 4;
        int step3 = date;
        int step4 = months.get(month);
        int step5 = value(year);
        int step6 = step1 + step2 + step3 + step4 + step5;
        int step7 = step6 % 7;

        if (isLeapYear(year) == 1 && date <= 29 && (month=="jan" || month=="feb")) {
            step7 = (step7 - 1) % 7;
        }

        String day = days.get(Integer.toString(step7));
        return day;
    }
    public static int value(int year) {
        if ((year >= 1600 && year <= 1699) || (year >= 2000 && year <= 2099)) {
            return 6;
        }
        if (year >= 1700 && year <= 1799) {
            return 2;
        }
        if (year >= 1800 && year <= 1899) {
            return 4;
        }
        if (year >= 1900 && year <= 1999) {
            return 0;
        }
        return 0;
    }

    public static int isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }
}
