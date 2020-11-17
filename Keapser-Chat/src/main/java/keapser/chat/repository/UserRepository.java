package keapser.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import keapser.chat.model.ChatMessage;

public interface UserRepository extends JpaRepository<ChatMessage, Long> {

}
