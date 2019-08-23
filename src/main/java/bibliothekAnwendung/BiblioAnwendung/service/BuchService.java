package bibliothekAnwendung.BiblioAnwendung.service;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Buch;
import bibliothekAnwendung.BiblioAnwendung.repo.BuchRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class BuchService {


    private BuchRepository buchRepository;

    public BuchService (BuchRepository buchRepository) { this.buchRepository = buchRepository;}

    Optional<Buch> fincBuchByTitel(Buch buch) { return buchRepository.findBuchByTitel ( buch.getTitel () );}
    List<Buch> findAll() {return buchRepository.findAll ();}
    Optional<Buch> findBuch(Buch buch){
        return buchRepository.findBuchByTitel ( buch.getTitel () );
    }


}
