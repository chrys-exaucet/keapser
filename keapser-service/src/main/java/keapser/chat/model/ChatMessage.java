package keapser.chat.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@Data
public class ChatMessage {

    @Id
    private Long id;


    private String sender;

    private String content;

    private MessageType type;

    public enum MessageType {

        CHAT, LEAVE, JOIN

    }


}
