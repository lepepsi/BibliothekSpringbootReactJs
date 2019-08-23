package bibliothekAnwendung.BiblioAnwendung.controller;
import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Buch;
import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import bibliothekAnwendung.BiblioAnwendung.repo.AusleihRepository;
import bibliothekAnwendung.BiblioAnwendung.repo.BuchRepository;
import bibliothekAnwendung.BiblioAnwendung.repo.PersonRepository;
import bibliothekAnwendung.BiblioAnwendung.resource.AusleiheDto;
import bibliothekAnwendung.BiblioAnwendung.resource.BuchDto;
import bibliothekAnwendung.BiblioAnwendung.resource.PersonDto;
import bibliothekAnwendung.BiblioAnwendung.controller.BuchController;
import bibliothekAnwendung.BiblioAnwendung.controller.PersonController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@Slf4j

public class AusleihController {

    public final AusleihRepository ausleihRepository;
    public final BuchRepository buchRepository;
    public final PersonRepository personRepository;

    @Autowired
    public AusleihController(AusleihRepository ausleihRepository, BuchRepository buchRepository, PersonRepository personRepository){
        this.buchRepository = buchRepository;
        this.ausleihRepository = ausleihRepository;
        this.personRepository =  personRepository;
    }


    private PersonDto convertaPersontoDtoo(Person aperson){
        PersonDto personDto = new PersonDto (  );
        personDto.setUserName ( aperson.getUserName () );
        personDto.setFirstName ( aperson.getFirstName () );
        personDto.setUserName ( aperson.getUserName () );
        personDto.setEmail ( aperson.getEmail () );
        return personDto;
    }


    private BuchDto convertaBuchtoDto (Buch abuch){

        BuchDto buchDto = new BuchDto ();
        buchDto.setTitel (abuch.getTitel());
        buchDto.setId_BuchGenre (abuch.getId_BuchGenre());
        buchDto.setIsbn ( abuch.getIsbn ());
        buchDto.setBestand ( abuch.getBestand () );
        return buchDto;
    }

    private AusleiheDto convertAusleihetoDto (Ausleihe ausleihe){

        AusleiheDto ausleiheDto = new AusleiheDto();
        Buch buch = new Buch();
        Person person  = new Person ();

        ausleiheDto.setAusleihBeginn (ausleihe.getAusleihBeginn());
        ausleiheDto.setAusleihEnde (ausleihe.getAusleihEnde());;
        ausleiheDto.setPersonDto (convertaPersontoDtoo( ausleihe.getPerson () ) );
        ausleiheDto.setBuchDto ( convertaBuchtoDto(ausleihe.getBuch ()) );

         return ausleiheDto;

    }

    @GetMapping("/ausleihe")
    public List<AusleiheDto> getAllausleihe(){
        List <Ausleihe> listofausleihe = ausleihRepository.findAll ();
        List <AusleiheDto> listofausleiheDto = listofausleihe.stream ().map ( ausleihe -> convertAusleihetoDto ( ausleihe ) ).collect ( Collectors.toList () );
        return listofausleiheDto;
    }


   @GetMapping("/ausleihe/person/{username}")
    public List<AusleiheDto> getAusleiheByPersonId(@PathVariable String username){

       Person thePerson = personRepository.findByUserName( username );

        List <Ausleihe> ausleihePerson = ausleihRepository.findAusleiheByPerson (thePerson);

        List<AusleiheDto> ausleiheDtoPerson = ausleihePerson.stream ().map ( ausleihe -> convertAusleihetoDto ( ausleihe )  ).collect(Collectors.toList());

        return ausleiheDtoPerson;
    }

    @GetMapping("/ausleihe/date/{date1}{date2}")
    public List<AusleiheDto> getAusleiheBetweenDate(@PathVariable Instant date1, @PathVariable Instant date2){

        List <Ausleihe> ausleiheBeginnDateBetween = ausleihRepository.findAusleiheByAusleihBeginnBetween ( date1, date2 );

        List<AusleiheDto> ausleiheDtoBeginnDateBetween = ausleiheBeginnDateBetween.stream ().map ( ausleihe -> convertAusleihetoDto ( ausleihe ) ).collect(Collectors.toList());

        return ausleiheDtoBeginnDateBetween;
    }

}
