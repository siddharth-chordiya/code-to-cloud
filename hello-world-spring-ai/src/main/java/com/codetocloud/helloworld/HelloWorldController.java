package com.codetocloud.helloworld;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
class HelloWorldController {

	private final ChatClient chatClient;
	public HelloWorldController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	 }

	private final String systemInstruction = "You are a specialized customer" +
			"support agent for a IPL match event. Please allow user to ask you only about -- " +
			"1. Date and Time of the event" +
			"2. Ticket collection process and venue details" +
			"3. Any payment related information" +
			"Respond strictly with //I do not have access to the information related to this query// if user asks anything apart from this";

	@GetMapping("/chat")
	String hello(@RequestParam String ip) {
		return chatClient.prompt()
				.user(ip)
				.system(systemInstruction)
				.call()
				.content();
	}

}
