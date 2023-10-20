package com.nivak.dayfinder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nivak.dayfinder.entity.Entity;
import com.nivak.dayfinder.findday.FindDay;

@Controller
public class DayFinderController {
    @GetMapping("/")
    public String Home(){
        return "dayfind";
    }
    @Autowired
    private FindDay findDay;

    @PostMapping("/dayfind")
    public String dayfind(@ModelAttribute Entity data,Model model){
        int date = data.getDate();
        String month = data.getMonth();
        int year = data.getYear();

        String day = findDay.dayCheck(date,month,year);

        Map<String, String> months = new HashMap<>();
        months.put("jan", "January");
        months.put("feb", "February");
        months.put("mar", "March");
        months.put("apr", "April");
        months.put("may", "May");
        months.put("june", "June");
        months.put("july", "July");
        months.put("aug", "August");
        months.put("sep", "September");
        months.put("oct", "October");
        months.put("nov", "November");
        months.put("dec", "December");
        
        String message = String.format("The day for "+date+"/"+months.get(month)+"/"+year+" is");
        
        model.addAttribute("message", message);
        model.addAttribute("day", day);
        return "dayfind";
    }
}

