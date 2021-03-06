package io.github.hardlitchi.rest.chat.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.github.hardlitchi.rest.common.entity.AbstractEntity;
import io.github.hardlitchi.rest.common.entity.NotifiedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 【Entityクラス】
 * <br>
 * チャットメッセージ.
 * @author hardlitchi
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true)
@Entity
public class ChatMessage extends AbstractEntity implements NotifiedEntity, Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = 4745990851194558258L;

	/** ID(内部識別子). */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final String id = UUID.randomUUID().toString();
	/** タイトル. */
	private String title;
	/** 本文. */
	private String message;
	/** 送信区分. */
	private String transcategory;
	/** 送り主タイプ. */
	private String sendertype;
	/** 送り主. */
	private String sender;
	/** 宛先タイプ. */
	private String destinationtype;
	/** 宛先. */
	private String destination;
	/** 送信日時. */
	private Timestamp senddatetime;

	/*
	 * (非 Javadoc)
	 * @see io.github.hardlitchi.rest.common.entity.NotifiedEntity#getNotifiedEntityType()
	 */
	@Override
	public String getNotifiedentitytype() {
		return "CHAT_MESSAGE";
	}
}
