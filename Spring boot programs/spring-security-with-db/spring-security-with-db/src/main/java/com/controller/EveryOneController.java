package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("everyone")
public class EveryOneController {

	@GetMapping(value = "")
	public String open() {
		return "everyone";
	}
}
