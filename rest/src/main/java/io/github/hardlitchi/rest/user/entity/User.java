package io.github.hardlitchi.rest.user.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.github.hardlitchi.rest.common.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 【Entityクラス】
 * <br>
 * ユーザ情報.
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
public class User extends AbstractEntity implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -3386823071914556140L;

	/** ID(内部識別子). */
	@Id
	@GeneratedValue
	private final String id = UUID.randomUUID().toString();
	/** ユーザID(外部識別子). */
	private String username;
	/** ファーストネーム. */
	private String firstname;
	/** ミドルネーム. */
	private String middlename;
	/** ファミリーネーム. */
	private String famillyname;
	/** 性別(実数部). */
	private double sexreal;
	/** 性別(虚数部). */
	private double seximage;
	/** ユーザID公開設定ID. */
	private Long usernameflag;
	/** ファーストネーム公開設定ID. */
	private Long firstnameflag;
	/** ミドルネーム公開設定ID. */
	private Long middlenameflag;
	/** ファミリーネーム公開設定ID. */
	private Long famillynameflag;
	/** 性別公開設定ID. */
	private Long sexflag;
}
