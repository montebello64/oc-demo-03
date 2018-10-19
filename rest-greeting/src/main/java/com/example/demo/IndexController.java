package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
private static final Logger logger = LoggerFactory.getLogger(IndexController.class);	
	
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
	
	private String randomGreeting() {
		String[] items = { "Hi", "Hello", "Ahoi", "Ei gude", "Grüezi" };
		int idx = new Random().nextInt(items.length);
		String item = items[idx];
		logger.info(">>> Hostname: " + getHostname() + ", randomGreeting(): " + item);
		return item;
	}

	@GetMapping("/")
	public String index() {
		return randomGreeting();
	}

}
