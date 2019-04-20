package io.github.hardlitchi.rest.chat.exception;

import io.github.hardlitchi.rest.common.exception.BaseException;

/**
 * 【チャット例外クラス】
 * @author hardlitchi
 * @version 1.0
 */
public class ChatException extends BaseException {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -4458376507049468180L;

	public ChatException() {
		super();
	}

	public ChatException(String message) {
		super(message);
	}

	public ChatException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChatException(Throwable cause) {
		super(cause);
	}

	public ChatException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
	}

	public ChatException(String message, String errorcode) {
		super(message);
		this.setErrorcode(errorcode);
	}

	public ChatException(String message, Throwable cause, String errorcode) {
		super(message, cause);
		this.setErrorcode(errorcode);
	}

	public ChatException(Throwable cause, String errorcode) {
		super(cause);
		this.setErrorcode(errorcode);
	}

	public ChatException(String message, Throwable cause, String errorcode,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
		this.setErrorcode(errorcode);
	}

	public static ChatException create(String errorcode) {
		ChatException ce = new ChatException();
		ce.setErrorcode(errorcode);
		return ce;
	}
}
