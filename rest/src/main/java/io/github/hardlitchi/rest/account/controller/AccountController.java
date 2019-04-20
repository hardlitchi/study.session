package io.github.hardlitchi.rest.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.hardlitchi.rest.account.entity.Account;
import io.github.hardlitchi.rest.account.service.AccountService;

/**
 * 【Controllerクラス】
 * アカウント(ログイン情報)管理テーブル
 * @author hardlitchi
 * @version 1.0
 */
@RestController
public class AccountController {

	/** アカウント(ログイン情報)操作ロジック. */
	@Autowired
	private AccountService accountService;

	/**
	 * アカウント登録.
	 * @param username ユーザ名
	 * @param password パスワード
	 * @param admin 権限
	 * @return トークン情報
	 */
	@PostMapping(path="/signup")
	public Account signup(String username, String password, String admin) {
		Account account = accountService.saveAndFlush(username, password, "TRUE".equals(admin));
		return account;
	}
}
