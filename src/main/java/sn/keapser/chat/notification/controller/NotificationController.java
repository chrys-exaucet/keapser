package sn.keapser.chat.notification.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.keapser.chat.notification.dto.MessageDto;
import sn.keapser.chat.notification.service.MessageService;

@Controller
@RequestMapping("/notification")
public class NotificationController {
    private MessageService smsService ;

    @PostMapping
    void SendMessage(MessageDto sms){
        smsService.SendMessage(sms);
    }


}
