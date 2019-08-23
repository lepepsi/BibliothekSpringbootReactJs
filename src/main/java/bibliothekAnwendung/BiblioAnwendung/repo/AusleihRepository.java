package bibliothekAnwendung.BiblioAnwendung.repo;

import bibliothekAnwendung.BiblioAnwendung.entity.Ausleihe;
import bibliothekAnwendung.BiblioAnwendung.entity.Buch;
import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AusleihRepository extends JpaRepository<Ausleihe, Long> {


    Optional<Ausleihe> findAusleiheByAusleihBeginn(Long id);

    @Override
    List<Ausleihe> findAll();
    List<Ausleihe> findAusleiheByBuch(Buch buch);
    List<Ausleihe> findAusleiheByPerson(Person person);
    List<Ausleihe> findAusleiheByAusleihBeginn(Instant instant);
    List<Ausleihe> findAusleiheByAusleihEnde(Instant instant);
    List<Ausleihe> findAusleiheByAusleihBeginnBetween(Instant date1, Instant date2);
    List<Ausleihe> findAusleiheByCreationDateEquals(Date date1);
}
