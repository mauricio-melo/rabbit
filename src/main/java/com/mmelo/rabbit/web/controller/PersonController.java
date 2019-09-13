package com.mmelo.rabbit.web.controller;

import com.mmelo.rabbit.dto.PersonDTO;
import com.mmelo.rabbit.service.PersonService;
import com.mmelo.rabbit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(PersonController.PERSON_ENDPOINT)
public class PersonController {

    public static final String PERSON_ENDPOINT = "/person";
    private final PersonService personService;
    private final ModelMapper modelMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void save(@Valid @RequestBody final List<PersonVO> personVOList) {
        this.personService.process(this.voToDTO(personVOList));
    }

    private List<PersonDTO> voToDTO(final List<PersonVO> personVOList) {
        return personVOList.stream()
                .map(personVO -> this.modelMapper.map(personVO, PersonDTO.class))
                .collect(Collectors.toList());
    }
}
