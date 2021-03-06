package io.github.hardlitchi.rest.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.hardlitchi.rest.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsername(String username);

	@Query("SELECT u FROM User u INNER JOIN Publication p ON p.objectid = u.id AND p.objecttype = 'USER' AND (p.authtype LIKE '%_READ%' AND (p.targettype = 'USER' AND (p.targetid = :userid OR p.targetid = 0)))")
	List<User> findAllByUserid(@Param("userid") String userid, Pageable pageable);
}
