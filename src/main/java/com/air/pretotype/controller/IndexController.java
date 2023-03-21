package com.air.pretotype.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.air.pretotype.service.IndexService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	private final IndexService indexService;
	@GetMapping({"","/"})
	public String index(HttpServletRequest request, Model model){
		indexService.saveVisitCount(request);
		try {
			model.addAttribute("todayCount",indexService.getTodayCount());
			model.addAttribute("totalCount",indexService.getTotalCount());
		} catch (Exception e){
			e.printStackTrace();
		}
		return "index";
	}



}
