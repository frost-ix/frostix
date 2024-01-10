package com.frostix.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index() {
		return "Home index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main page";
	}
}