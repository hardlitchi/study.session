package io.github.hardlitchi.rest.common.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * 公開設定.
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
public class Publication extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = -8062323049376473629L;

	/** ID(内部識別子). */
	@Id
	@GeneratedValue
	private final String id = UUID.randomUUID().toString();

	/** 設定対象タイプ. */
	private String objecttype;
	/** 設定対象ID. */
	private String objectid;
	/** 権限区分. */
	private String authtype;
	/** 対象種別. */
	private String targettype;
	/** 対象ID. */
	private String targetid;
}
