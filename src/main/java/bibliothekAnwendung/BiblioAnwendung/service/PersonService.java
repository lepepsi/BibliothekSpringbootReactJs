package bibliothekAnwendung.BiblioAnwendung.service;

import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import bibliothekAnwendung.BiblioAnwendung.repo.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) { this.personRepository = personRepository;}

    public Person findByuserNameIgnoreCase( String userName) { return  personRepository.findByUserNameIgnoreCase ( userName ).get ();}

    public Person findByUserName(String userName) { return personRepository.findByUserName ( userName ) ;}
}
