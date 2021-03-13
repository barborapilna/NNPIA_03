package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Controller
    public class GreetingController {

    	// Takhle:
    	private final CounterService counterService;

		public GreetingController(@Qualifier("superCounterServiceImpl") CounterService counterService) {
			this.counterService = counterService;
		}

		// Nebo to same takto:
		//@Autowired
		//private CounterService counterService;

		@RequestMapping(value = "/greeting", method = {RequestMethod.GET, RequestMethod.POST})
		public String requestGreeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name , Model model){
			counterService.add();
			model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
			return "greeting";
		}

    	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
		public String listUsersInvoices(@PathVariable("name") String userName , Model model){
			counterService.add();
    		model.addAttribute("name", StringUtils.toUpperCase(userName, Locale.ENGLISH));
			model.addAttribute("counter", counterService.getCounter());
    		return "greeting";
		}
    }
}
