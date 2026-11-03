package com.rays.ctl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestCtl {

	@GetMapping
	public String get() {
		return "this is default get method";
	}

	@PostMapping
	public String submit() {
		return "this is default post method";
	}

	@GetMapping("get")
	public String get1() {
		return "this is endpoint get method..";
	}

	@PostMapping("save")
	public String submit1() {
		return "this is endpoint post method..";
	}

}