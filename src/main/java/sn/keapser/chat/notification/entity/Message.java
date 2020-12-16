package sn.keapser.chat.notification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Message")

public class Message {
    @Id
    @Email
    private String id;
    @NotNull
    private String content;
}
