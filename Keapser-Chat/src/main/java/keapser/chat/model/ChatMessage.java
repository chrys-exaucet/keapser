package keapser.chat.model;

import javax.persistence.Table;

import lombok.Data;

@Table
@Data
public class ChatMessage {

	
	private String sender;

	private String content;

	private MessageType type;

	public enum MessageType {
		
		CHAT, LEAVE, JOIN

	}



}
