package com.lxy.app.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lxy.app.domain.test.SayHello;
import com.lxy.app.service.test.HelloService;
import com.lxy.app.service.test.impl.HelloServiceImpl;

@Controller
public class HelloController {

	private HelloService helloService = new HelloServiceImpl();

	@RequestMapping("/helloWorld")
	public String getSayHello(Model model) {
		SayHello sayHello = helloService.getSayHello();
		model.addAttribute("hello", sayHello.toString());
		return "/modules/test/index";
	}

	public static HelloController instance = null;

	public static HelloController getInstance() {
		if (instance == null) {
			instance = new HelloController();
		}
		return instance;
	}
}
