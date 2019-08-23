package bibliothekAnwendung.BiblioAnwendung.repo;

import bibliothekAnwendung.BiblioAnwendung.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;




public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findByUserNameIgnoreCase( String userName);
  Person findByUserName(String userName);


}
