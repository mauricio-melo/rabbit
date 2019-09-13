package com.mmelo.rabbit.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = -6656408854904405589L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_person")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "position")
    private String position;

    @Column(name = "login")
    private String login;

}
