CREATE TABLE person (
  idt_person                    BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  full_name  	                VARCHAR(255)  NOT NULL,
  position  	                VARCHAR(255)  NOT NULL,
  login                         VARCHAR(255)  NOT NULL
);

insert INTO person(full_name, position, login)
values('Jose Silva', 'Developer', 'jose.silva');