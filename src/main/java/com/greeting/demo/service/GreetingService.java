package com.greeting.demo.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greeting.demo.dto.UserDto;
import com.greeting.demo.model.Greeting;
import com.greeting.demo.model.User;
import com.greeting.demo.repository.IGreetingRepository;



@Service
public class GreetingService implements IGreetingService {

	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IGreetingRepository igreetingRepository;

	@Override
	public Greeting greetingMessage() {

		return igreetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)));
	}

	@Override
	public String greetingMessageByName(UserDto userDto) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userDto, user);
		return ("Hello " + user.getFirstName() + " " + user.getLastName());
	}

	/**
	 * method call to find message by Id From Repository
	 */
	@Override
	public Greeting findById(long findId) {
		return igreetingRepository.findById(findId).get();
	}

	/**
	 * method call to list all the messages in repository
	 */
	@Override
	public List<Greeting> getAllMessages() {
		return igreetingRepository.findAll();
	}

	@Override
	public Greeting editMessage(Greeting greeting) {
		return igreetingRepository.save(new Greeting(1, "Hello Suraj"));
	}

}