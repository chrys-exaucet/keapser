package sn.keapser.chat.notification.mapper;

import org.mapstruct.Mapper;
import sn.keapser.chat.notification.dto.MessageDto;
import sn.keapser.chat.notification.entity.Message;


@Mapper
public interface MessageMapper {

    MessageDto messageToMessageDto(Message sms) ;
    Message messageDtoToMessage(MessageDto sms) ;

}
