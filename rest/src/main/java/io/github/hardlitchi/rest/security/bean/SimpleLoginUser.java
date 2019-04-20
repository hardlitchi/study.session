package io.github.hardlitchi.rest.security.bean;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import io.github.hardlitchi.rest.account.entity.Account;

public class SimpleLoginUser extends User {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -7219667563637641416L;
	// Userエンティティ
    private Account account;

    public Account getAccount() {
        return account;
    }

    public SimpleLoginUser(Account account) {
        super(account.getUsername(), account.getPassword(), determineRoles(account.getAdmin()));
        this.account = account;
    }

    private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("ROLE_USER");
    private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");

    private static List<GrantedAuthority> determineRoles(boolean isAdmin) {
        return isAdmin ? ADMIN_ROLES : USER_ROLES;
    }
}
