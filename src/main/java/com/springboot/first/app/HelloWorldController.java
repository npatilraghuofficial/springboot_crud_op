package com.springboot.first.app;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
////get
////post
////put
////delete

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello world";
}
	
	
	

}
