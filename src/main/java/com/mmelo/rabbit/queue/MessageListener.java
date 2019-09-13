package com.mmelo.rabbit.queue;

import com.mmelo.rabbit.constants.Constants;
import com.mmelo.rabbit.dto.PersonDTO;
import com.mmelo.rabbit.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageListener {

    private final PersonService personService;

    @RabbitListener(queues = Constants.QUEUE_PERSON)
    public void receiveNames(final PersonDTO personDTO) throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();
        log.info(" <-- Received '" + personDTO + "'");
        this.personService.save(personDTO);
        watch.stop();
        log.info(" Received [" + personDTO + "] done in " + watch.getTotalTimeSeconds() + "s");
    }
}