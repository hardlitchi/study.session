package io.github.hardlitchi.rest.account.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * アカウント情報.
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
public class Account extends AbstractEntity implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -1871639060004389532L;

	/** ID(内部識別子). */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final String id = UUID.randomUUID().toString();
	/** ユーザID. */
	@Column(name = "username", nullable = false, length = 128)
	private String username;
	/** パスワード. */
	@JsonIgnore
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	/** ユーザ権限. */
	@Column(name = "admin_flag", nullable = false)
	private Boolean admin;
	/** トークン. */
	@Column(name = "token", nullable = true, length = 255)
	private String token;
	@JsonIgnore
	@Column(name = "expire", nullable = true)
	private Timestamp expire;

	/**
	 * アカウント情報を生成する.
	 * @param username ユーザID
	 * @param password パスワード
	 * @param admin ユーザ権限
	 * @return
	 */
	public static Account of(String username, String password, Boolean admin) {
		return Account.builder().username(username).password(password).admin(admin).build();
	}

}
