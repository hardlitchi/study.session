package io.github.hardlitchi.rest.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hardlitchi.rest.chat.entity.ChatMessage;
import io.github.hardlitchi.rest.hello.bean.ChatMessageResponse;
import io.github.hardlitchi.rest.hello.service.HelloService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

	@Autowired
	private HelloService helloService;

	@ApiOperation(value = "挨拶", notes = "挨拶をします。",
			httpMethod = "POST", consumes = "application/json",response = ChatMessage.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "指定された相手への挨拶", response = ChatMessage.class),
			@ApiResponse(code = 500, message = "特定の相手へのエラー内容", response = ChatMessage.class)
	})
	@PostMapping(value = "/{name}")
	public ChatMessageResponse hello(@PathVariable String name) {

		ChatMessage chatMessage = helloService.exec(name);

		ChatMessageResponse response = new ChatMessageResponse(chatMessage);

		return response;
	}
}
