package com.aaj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    @GetMapping("/pieChart")
    public String pieChart() {
        return "pieChart.html";
    }

    @GetMapping("/barChart")
    public String barChart() {
        return "barChart.html";
    }
}
