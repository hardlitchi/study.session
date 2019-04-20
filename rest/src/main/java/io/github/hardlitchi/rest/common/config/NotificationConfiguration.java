package io.github.hardlitchi.rest.common.config;

import java.util.List;

import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.github.hardlitchi.rest.common.handler.NotificationHandler;

public class NotificationConfiguration implements WebMvcConfigurer {
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
		handlers.add(new NotificationHandler());
	}
}
