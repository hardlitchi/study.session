package io.github.hardlitchi.rest.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hardlitchi.rest.chat.entity.ChatMessage;
import io.github.hardlitchi.rest.user.bean.UserRequestBean;
import io.github.hardlitchi.rest.user.entity.User;
import io.github.hardlitchi.rest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "ユーザ作成", notes = "ユーザを作成します。",
			httpMethod = "GET", consumes = "application/json",response = ChatMessage.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "指定された相手への挨拶", response = ChatMessage.class),
			@ApiResponse(code = 500, message = "特定の相手へのエラー内容", response = ChatMessage.class)
	})
	@GetMapping(value = "/{username:^[0-9a-zA-Z]+$}")
	public User getUser(@PathVariable String username) {

		User user = userService.findByUsername(null, username);

		return user;
	}

	@ApiOperation(value = "ユーザ作成", notes = "ユーザを作成します。",
			httpMethod = "GET", consumes = "application/json",response = ChatMessage.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "指定された相手への挨拶", response = ChatMessage.class),
			@ApiResponse(code = 500, message = "特定の相手へのエラー内容", response = ChatMessage.class)
	})
	@GetMapping()
	public List<User> getUsers(Pageable pageable) {

		List<User> userList = userService.findAllByUserid(null, pageable);

		return userList;
	}

	@ApiOperation(value = "ユーザ作成", notes = "ユーザを作成します。",
			httpMethod = "POST", consumes = "application/json",response = ChatMessage.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "指定された相手への挨拶", response = ChatMessage.class),
			@ApiResponse(code = 500, message = "特定の相手へのエラー内容", response = ChatMessage.class)
	})
	@PostMapping()
	public User postUsers(@Validated @RequestBody UserRequestBean user, Errors errors) {

		User userres = userService.saveAndFlush(null, user.getUser());

		return userres;
	}
}
