package bibliothekAnwendung.BiblioAnwendung.controller;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Buch;
import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import bibliothekAnwendung.BiblioAnwendung.repo.AusleihRepository;
import bibliothekAnwendung.BiblioAnwendung.repo.BuchRepository;
import bibliothekAnwendung.BiblioAnwendung.resource.AusleiheDto;
import bibliothekAnwendung.BiblioAnwendung.resource.BuchDto;
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

public class BuchController {

    public final BuchRepository buchRepository;
    public final AusleihRepository ausleihRepository;
    @Autowired

    public BuchController(BuchRepository buchRepository, AusleihRepository ausleihRepository){
        this.buchRepository = buchRepository;
        this.ausleihRepository = ausleihRepository;
    }

    private BuchDto convertaBuchDto (Buch abuch){

        BuchDto buchDto = new BuchDto();
        buchDto.setTitel ( abuch.getTitel () );
        buchDto.setId_BuchGenre ( abuch.getId_BuchGenre () );
        buchDto.setIsbn ( abuch.getIsbn () );
        buchDto.setBestand ( abuch.getBestand () );
       // buchDto.setAusleiheBuch ( abuch.getAusleiheBuch () );
        return buchDto;
    }

//    public Set<Ausleihe> buchAusleihe(Buch book){
//        List <Ausleihe> listofausleihe = ausleihRepository.findAll ();
//        Set <Ausleihe> listofbuchAusleihe = new HashSet<Ausleihe> ( );
//        for (Ausleihe ausleihe : listofausleihe){
//            if (ausleihe.getBuch ().getId () == book.getId ()){
//                listofbuchAusleihe.add ( ausleihe );
//            }
//
//        }
//        return listofbuchAusleihe;
//    }








    @GetMapping("/buch")

    public List<BuchDto> getAllbuecher(){
        List <Buch> listofbuecher = buchRepository.findAll ();
        List<BuchDto> listofbuecherDto = listofbuecher.stream ().map ( buch -> convertaBuchDto ( buch ) ).collect(Collectors.toList());

        return listofbuecherDto;
    }


}
