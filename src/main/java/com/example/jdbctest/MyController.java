package com.example.jdbctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired MovieRepository movieRepository;
	
	@RequestMapping("/")
	public String home() {
		return "안녕하세요! 자료 보내드립니다...<hr>"
				+ movieRepository.findAll().toString();
	}
}
