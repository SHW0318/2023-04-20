package com.company.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/write_form")
	public String write_form() {
		
		return "writeForm";
	}
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		return "views";
	}

}
