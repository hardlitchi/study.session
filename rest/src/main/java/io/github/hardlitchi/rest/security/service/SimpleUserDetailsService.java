package io.github.hardlitchi.rest.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.hardlitchi.rest.account.repository.AccountRepository;
import io.github.hardlitchi.rest.security.bean.SimpleLoginUser;

/**
 * Userエンティティ
 */
@Service("simpleUserDetailsService")
public class SimpleUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public SimpleUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        // emailでデータベースからユーザーエンティティを検索する
        return accountRepository.findByUsername(username)
                .map(SimpleLoginUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

}
