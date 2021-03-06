package io.github.hardlitchi.rest.account.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.hardlitchi.rest.account.entity.Account;
import io.github.hardlitchi.rest.account.repository.AccountRepository;
import io.github.hardlitchi.rest.common.util.TimestampUtil;

/**
 * 【Serviceクラス】
 * アカウント情報取扱いロジック.
 * @author hardlitchi
 * @version 1.0
 */
@Service
public class AccountService {

	/** アカウントRepository. */
	@Autowired
	private AccountRepository accountRepository;

	/** Timestamp操作ロジック. */
	@Autowired
	private TimestampUtil timestampUtil;

	/** パスワードエンコーダ. */
	private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();;

	/**
	 * ユーザIDとパスワードでアカウント情報を取得する.
	 * @param username ユーザID
	 * @param password パスワード
	 * @return アカウント情報
	 */
	public Account get(String username, String password) {
		return accountRepository.findByUsernameAndPassword(username, passwordEncoder.encode(password)).orElse(null);
	}

	/**
	 * アカウント情報を登録する.
	 * @param username ユーザID
	 * @param password パスワード
	 * @param admin 管理者権限か否か
	 * @return アカウント情報
	 */
	public Account saveAndFlush(String username, String password, Boolean admin) {
		Account account = Account.of(username, passwordEncoder.encode(password), admin);

		Timestamp now = timestampUtil.now();
		Timestamp expire = timestampUtil.add(now, Calendar.DATE, 30);

		account.setCreateTimestamp(now);
		account.setUpdateTimestamp(now);
		account.setExpire(expire);
		account.setToken(UUID.randomUUID().toString());

		return accountRepository.saveAndFlush(account);
	}
}
