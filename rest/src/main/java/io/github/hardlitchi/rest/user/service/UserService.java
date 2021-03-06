package io.github.hardlitchi.rest.user.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import io.github.hardlitchi.rest.account.entity.Account;
import io.github.hardlitchi.rest.common.util.TimestampUtil;
import io.github.hardlitchi.rest.user.entity.User;
import io.github.hardlitchi.rest.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private TimestampUtil timestampUtil;

	@Autowired
	private UserRepository userRepository;

	public User findByUsername(Account account, String username) {

		Optional<User> optionalUser = userRepository.findByUsername(username);

		return optionalUser.orElse(null);
	}

	public List<User> findAllByUserid(Account account, Pageable pageable) {

		Optional<User> optionalUser = userRepository.findByUsername(account.getUsername());

		if (ObjectUtils.isEmpty(optionalUser)) {
			return List.of();
		}

		return userRepository.findAllByUserid(optionalUser.get().getId(), pageable);
	}

	public User saveAndFlush(Account account, User user) {

		Timestamp now = timestampUtil.now();

		if (null == user.getCreateTimestamp()) {
			user.setCreateTimestamp(now);
		}

		user.setUpdateTimestamp(now);

		return userRepository.saveAndFlush(user);
	}
}
