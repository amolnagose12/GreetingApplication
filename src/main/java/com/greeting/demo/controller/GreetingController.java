package com.greeting.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.demo.dto.UserDto;
import com.greeting.demo.model.Greeting;
import com.greeting.demo.service.IGreetingService;


/**
 * @RestController
 * @RequestMapping: mapping web requests onto methods in request-handling
 *                  classes with flexible method signatures.
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IGreetingService greetingService;

	/**
	 * @GetMapping: mapping HTTP GET requests onto specific handler methods
	 * @RequestParam: method parameter should be bound to a web request parameter.
	 */
	@GetMapping(value = { "", "/", "/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/**
	 * @PathVariable: method parameter should be bound to a URI template variable.
	 *                Supported for RequestMapping annotated handler methods.
	 */
	@GetMapping("/{name}")
	public Greeting greetings(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/service")
	public Greeting greeting() {
		return greetingService.greetingMessage();

	}
	
    @PostMapping("/post")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }


}