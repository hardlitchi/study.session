package io.github.hardlitchi.rest.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.github.hardlitchi.rest.chat.entity.ChatMessage;

@RepositoryRestResource(exported = false)
public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {

}
