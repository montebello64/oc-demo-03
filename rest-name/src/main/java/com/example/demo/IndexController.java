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
	
	private String randomName() {
		String[] names = { "Peter", "Paul", "Mary", "Mikel" };
		int idx = new Random().nextInt(names.length);
		String rName = names[idx];
		logger.info(">>> Hostname: " + getHostname() + ", randomName(): " + rName);
		return rName;
	}

	@GetMapping("/")
	public String index() {
		return randomName();
	}
	
}
