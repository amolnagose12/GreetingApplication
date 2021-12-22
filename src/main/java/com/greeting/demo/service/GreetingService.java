package com.greeting.demo.service;
import java.util.concurrent.atomic.AtomicLong;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.greeting.demo.dto.UserDto;
import com.greeting.demo.model.Greeting;
import com.greeting.demo.model.User;


@Service
public class GreetingService implements IGreetingService {

	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Override
	public Greeting greetingMessage() {

		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Override
	public String greetingMessageByName(UserDto userDto) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userDto, user);
		return ("Hello " + user.getFirstName() + " " + user.getLastName());
	}

}