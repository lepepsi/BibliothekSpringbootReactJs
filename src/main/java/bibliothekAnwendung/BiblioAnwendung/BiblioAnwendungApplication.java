package bibliothekAnwendung.BiblioAnwendung;

import bibliothekAnwendung.BiblioAnwendung.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiblioAnwendungApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioAnwendungApplication.class, args);
		Person alain = new Person (  );
		alain.setFirstName ( "alain" );
		alain.setEmail ( "bernard@whatsapp.com" );
		alain.setLastName ( "domtchouang" );
		alain.setUserName ( "bandit" );
	}

}
