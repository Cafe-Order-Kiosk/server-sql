package com.kiosk.cafe.controller;

import com.kiosk.cafe.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MenuService menuService;


}
