package io.github.hardlitchi.rest.account.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.github.hardlitchi.rest.account.entity.Account;

@RepositoryRestResource(exported = false)
public interface AccountRepository extends JpaRepository<Account, UUID> {

	Optional<Account> findByUsername(String username);

	Optional<Account> findByUsernameAndPassword(String username, String password);
}
