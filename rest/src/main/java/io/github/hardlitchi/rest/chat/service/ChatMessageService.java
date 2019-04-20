package io.github.hardlitchi.rest.chat.service;

import java.sql.Timestamp;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.hardlitchi.rest.chat.constant.ChatErrorCode;
import io.github.hardlitchi.rest.chat.entity.ChatMessage;
import io.github.hardlitchi.rest.chat.exception.ChatException;
import io.github.hardlitchi.rest.chat.repository.ChatMessageRepository;
import io.github.hardlitchi.rest.common.constant.StakeholderType;
import io.github.hardlitchi.rest.common.entity.AbstractEntity;
import io.github.hardlitchi.rest.common.util.TimestampUtil;
import io.github.hardlitchi.rest.user.entity.User;

/**
 * 【Serviceクラス】
 * チャットメッセージ取扱いロジック.
 * @author hardlitchi
 * @version 1.0
 */
@Service
public class ChatMessageService {

	/** Timestamp操作ロジック. */
	@Autowired
	private TimestampUtil timestampUtil;

	/**  チャットメッセージRepository. */
	@Autowired
	private ChatMessageRepository chatMessageRepository;

	/**
	 * チャットメッセージ送信.
	 * @param sender 送り主
	 * @param chatMessage チャットメッセージ
	 * @return チャットメッセージ
	 * @throws ChatException 送信時例外
	 */
	public ChatMessage sendMessage(User sender, ChatMessage chatMessage) throws ChatException {

		if (Objects.isNull(sender)) {
			throw ChatException.create(ChatErrorCode.CHAU0001.toString());
		}

		ChatMessage message = setUpSendMessage(sender, chatMessage);
		message = chatMessageRepository.saveAndFlush(message);

		return message;
	}

	private ChatMessage setUpSendMessage(AbstractEntity sender, ChatMessage chatMessage) {

		Timestamp now = timestampUtil.now();

		String sendertype = null;
		if (sender instanceof User) {
			sendertype = StakeholderType.USER.toString();
		} else {
			sendertype = StakeholderType.UNKNOWN.toString();
		}

		chatMessage.setSendertype(sendertype);
		chatMessage.setSender(sender.getId());
		chatMessage.setCreateTimestamp(now);
		chatMessage.setUpdateTimestamp(now);

		return chatMessage;
	}
}
