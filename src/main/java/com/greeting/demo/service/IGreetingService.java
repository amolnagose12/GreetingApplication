package com.greeting.demo.service;

import com.greeting.demo.dto.UserDto;
import com.greeting.demo.model.Greeting;

public interface IGreetingService {

	public Greeting greetingMessage();
	
	String greetingMessageByName(UserDto userDto);
}