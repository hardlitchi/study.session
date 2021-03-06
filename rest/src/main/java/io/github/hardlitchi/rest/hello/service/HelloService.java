package io.github.hardlitchi.rest.hello.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.hardlitchi.rest.chat.entity.ChatMessage;
import io.github.hardlitchi.rest.common.util.TimestampUtil;

@Service
public class HelloService {

	/** サービス名. */
	private final static String SERVICE_NAME = "W.Hello";
	/** サービスタイトル. */
	private final static String SERVICE_TITLE = "Greeting";

	/** 日時ユーティリティ. */
	@Autowired
	private TimestampUtil timestampUtil;

	/**
	 * 挨拶処理.
	 * @param name 対話者名
	 * @return 挨拶メッセージ
	 */
	public ChatMessage exec(String name) {

		var now = timestampUtil.now();

		ChatMessage responseMessage = new ChatMessage();
		responseMessage.setTitle(SERVICE_TITLE);
		responseMessage.setMessage(createMessage(name, now));
		responseMessage.setCreateTimestamp(now);
		responseMessage.setUpdateTimestamp(now);

		return responseMessage;
	}

	/**
	 * メッセージを作成する.
	 * @param name 対話者名
	 * @param now 現在日時
	 * @return 生成したメッセージ
	 */
	private String createMessage(String name, Timestamp now) {

		List<String> blackList = new ArrayList<>();
		blackList.add("無法者");

		var message = new StringBuilder();

		if (blackList.contains(name)) {
			return "もう二度と送ってこないでください。";
		}

		message.append(name);
		message.append("さん ");

		switch(timestampUtil.timespan(now)) {
			case MORNING:
				message.append("おはようございます");
				break;
			case NOON:
				message.append("こんにちは");
				break;
			case NIGHT:
				message.append("こんばんは");
				break;
			default :
				message.append("Hello World");
		}

		message.append("！！");

		return message.toString();
	}
}
