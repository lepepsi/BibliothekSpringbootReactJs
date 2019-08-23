package bibliothekAnwendung.BiblioAnwendung.repo;

import bibliothekAnwendung.BiblioAnwendung.entity.Buch;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BuchRepository extends JpaRepository<Buch, Long>{

    Optional<Buch> findBuchById( long id);

    Optional<Buch> findBuchByTitel(String titel);
}
