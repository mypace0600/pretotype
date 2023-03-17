package com.air.pretotype.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.air.pretotype.service.IndexService;


@Controller
public class IndexController {

	@Autowired
	private IndexService indexService;
	@GetMapping({"","/"})
	public String index(HttpServletRequest request, Model model){
		try {
			model.addAttribute("CountDto",indexService.visitCount(request));
		} catch (Exception e){
			e.printStackTrace();
		}
		return "index";
	}



}
