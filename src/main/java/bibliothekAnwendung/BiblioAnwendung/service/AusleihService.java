package bibliothekAnwendung.BiblioAnwendung.service;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Buch;
import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import bibliothekAnwendung.BiblioAnwendung.repo.AusleihRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j

public class AusleihService {

    private AusleihRepository ausleihRepository;

    @Autowired
    public AusleihService(AusleihRepository ausleihRepository) { this.ausleihRepository = ausleihRepository;}

    public List<Ausleihe> findAll() { return ausleihRepository.findAll ();}

    public List<Ausleihe> findAusleiheByBuch (Buch buch) { return  ausleihRepository.findAusleiheByBuch(buch);}

    public List<Ausleihe> findAusleiheByPerson (Person person) { return ausleihRepository.findAusleiheByPerson ( person ); }



    public List<Ausleihe> findAusleiheByAusleihBeginn (Instant instant) { return  ausleihRepository.findAusleiheByAusleihBeginn ( instant );}

    public  List<Ausleihe> findAusleiheByAusleihBeginnBetween(Instant date1, Instant date2) { return ausleihRepository.findAusleiheByAusleihBeginnBetween ( date1, date2 );}

    public List<Ausleihe> findAusleiheByCreationDateEquals(Date date1) { return ausleihRepository.findAusleiheByCreationDateEquals ( date1 );}
}
