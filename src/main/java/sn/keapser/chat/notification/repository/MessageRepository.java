package sn.keapser.chat.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.keapser.chat.notification.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository <Message, String> {

}
