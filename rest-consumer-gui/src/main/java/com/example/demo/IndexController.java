package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {
	

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);	
	
	@Value("${url.rest.name}")
	private String urlRestName;
	
	@Value("${url.rest.greeting}")
	private String urlRestGreeting;
	
	private String getHostname() {
		String hostname = "undefined";
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("oOpS ... ");
			e.printStackTrace();
		}
		return hostname;
	}
	
	private String randomRestName() {
		RestTemplate restTemplate = new RestTemplate();
		// String response = restTemplate.getForObject("http://localhost:9001", String.class);
		// String response = restTemplate.getForObject("http://rest-name:8080", String.class);
		logger.info(">>> Hostname: " + getHostname() + ", urlRestName: " + urlRestName);
		String response = restTemplate.getForObject(urlRestName, String.class);
		return response;
	}
	
	private String randomRestGreeting() {
		RestTemplate restTemplate = new RestTemplate();
		logger.info(">>> Hostname: " + getHostname() + ", urlRestGreeting: " + urlRestGreeting);
		String response = restTemplate.getForObject(urlRestGreeting, String.class);
		return response;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("greeting", randomRestGreeting());
		model.addAttribute("name", randomRestName());
		return "index";
	}

}
