package io.github.hardlitchi.rest.user.bean;

import java.io.Serializable;

import io.github.hardlitchi.rest.user.entity.User;
import lombok.Data;

/**
 * 【Beanクラス】
 * <br>
 * ユーザ情報リクエストBean.
 * @author hardlitchi
 * @version 1.0
 */
@Data
public class UserRequestBean implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -3386823071914556140L;

	/** ID(内部識別子). */
	private User user;
	/** ユーザID(外部識別子). */
	private String username;
	/** パスワード. */
	private String password;
}
