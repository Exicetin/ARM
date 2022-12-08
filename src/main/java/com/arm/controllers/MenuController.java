package com.arm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
public class MenuController {

    @RequestMapping(value = "/orders_list", method = GET)
    public String getOrdersList(){
        return "orders_list";
    }

    @RequestMapping(value = "/cards_list", method = GET)
    public String getCardsList(){
        return "cards_list";
    }

    @RequestMapping(value = "/dashboard", method = GET)
    public String getDashboard(){
        return "dashboard";
    }
    @RequestMapping(value = "/settings", method = GET)
    public String getSettings(){
        return "settings";
    }

    @RequestMapping(value = "/services", method = GET)
    public String getServices(){
        return "services";
    }




}
