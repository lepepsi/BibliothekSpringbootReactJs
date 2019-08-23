package bibliothekAnwendung.BiblioAnwendung.controller;


import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import bibliothekAnwendung.BiblioAnwendung.repo.AusleihRepository;
import bibliothekAnwendung.BiblioAnwendung.repo.PersonRepository;
import bibliothekAnwendung.BiblioAnwendung.resource.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@Slf4j
public class PersonController {

    public final PersonRepository personRepository;
    public final AusleihRepository ausleihRepository;

    @Autowired
    public PersonController(PersonRepository personRepository, AusleihRepository ausleihRepository) {
        this.personRepository = personRepository;
        this.ausleihRepository = ausleihRepository;
    }


    public PersonDto convertaPersontoDto(Person aperson){
        PersonDto personDto = new PersonDto (  );
        personDto.setUserName ( aperson.getUserName () );
        personDto.setFirstName ( aperson.getFirstName () );
        personDto.setLastName ( aperson.getLastName () );
        personDto.setUserName ( aperson.getUserName () );
        personDto.setEmail ( aperson.getEmail () );
      //  personDto.setAusleiheSetPerson ( personAusleihe(aperson) );
        return personDto;
    }

//    public Set <Ausleihe> personAusleihe(Person man){
//    List <Ausleihe> listofausleihe = ausleihRepository.findAll ();
//        Set <Ausleihe> listofpersonAusleihe = new HashSet<Ausleihe> ( );
//        for (Ausleihe ausleihe : listofausleihe){
//            if (ausleihe.getPerson ().getId () == man.getId ()){
//                listofpersonAusleihe.add ( ausleihe );
//            }
//        }
//        return listofpersonAusleihe;
//    }

    @GetMapping("/person")
    public List<PersonDto> getAllPersonen(){
        List<Person> listofperson = personRepository.findAll ();
        List<PersonDto> listofpersonDto = listofperson.stream ().map ( person -> convertaPersontoDto ( person ) ).collect ( Collectors.toList (  ) );
        return listofpersonDto;
    }


}
