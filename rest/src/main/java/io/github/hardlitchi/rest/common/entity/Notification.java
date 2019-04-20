package io.github.hardlitchi.rest.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 【Entityクラス】
 * <br>
 * 通知情報.
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
public class Notification extends AbstractEntity implements  NotifiedEntity, Serializable {

	/** ID(内部識別子). */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final String id = UUID.randomUUID().toString();
	/** 情報区分. */
	private String notifiedentitytype;
	/** 情報ID. */
	private String notifiedinfoid;
	/** 宛先タイプ. */
	private String destinationtype;
	/** 宛先. */
	private String destination;
	/** 送信日時. */
	private Timestamp senddatetime;
}
