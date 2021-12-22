package com.greeting.demo.service;

import java.util.List;

import com.greeting.demo.dto.UserDto;
import com.greeting.demo.model.Greeting;



public interface IGreetingService {

	public String greetingMessageByName(UserDto userDto);

	/**
	 * Method: Save in Repository
	 */
	public Greeting greetingMessage();

	/**
	 * Method: Find Message by Id from Repository
	 */
	public Greeting findById(long parseLong);

	/**
	 * Method: List All Messages from Repository
	 */
	public List<Greeting> getAllMessages();

	/**
	 * Method: edit messages from repository
	 */
	public Greeting editMessage(Greeting greeting);

}