package com.mmelo.rabbit.service;

import com.mmelo.rabbit.domain.Person;
import com.mmelo.rabbit.dto.PersonDTO;
import com.mmelo.rabbit.queue.MessageSender;
import com.mmelo.rabbit.repository.PersonRepository;
import com.mmelo.rabbit.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__({@Lazy}))
public class PersonService {

    private final MessageSender messageSender;
    private final PersonRepository personRepository;
    private final StringUtil stringUtil;
    private final ModelMapper modelMapper;

    public void process(final List<PersonDTO> dtos) {
        dtos.forEach(dto -> this.messageSender.sendPerson(PersonDTO.builder()
                .fullName(dto.getFullName())
                .position(dto.getPosition())
                .login(this.validateLogin(this.stringUtil.toCamelCase(dto.getFullName())))
                .build()));
    }

    private String validateLogin(final String login) {
        return Optional.ofNullable(this.personRepository.findByLogin(login))
                .map(person -> this.validateLogin(person.getLogin() + "1"))
                .orElse(login);
    }

    public void save(final PersonDTO personDTO) {
        this.personRepository.save(this.modelMapper.map(personDTO, Person.class));
    }
}
