package com.zhiyou100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zhiyou100.service.VideoService;

@Controller
public class FrontVideoController {
    @Autowired
	VideoService vs;
	
	
}
