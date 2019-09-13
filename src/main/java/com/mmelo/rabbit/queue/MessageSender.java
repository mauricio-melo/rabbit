package com.mmelo.rabbit.queue;

import com.mmelo.rabbit.constants.Constants;
import com.mmelo.rabbit.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate template;

    public void sendPerson(final PersonDTO personDTO) {
        this.sendMessage(Constants.QUEUE_PERSON, personDTO);
    }

    private void sendMessage(final String queue, final Object object) {
        try {
            this.template.convertAndSend(queue, object);
            log.info(" --> Sent '" + object + "'");
        } catch (Exception e) {
            log.error(e);
        }
    }
}